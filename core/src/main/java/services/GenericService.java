package services;

import dto.IGenericDto;
import entities.IGenericEntity;
import lombok.AllArgsConstructor;
import mappers.IGenericMapper;
import repositories.IGenericRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
public abstract class GenericService<E extends IGenericEntity, D extends IGenericDto> {

    private final IGenericRepository<E> genericRepository;

    private final IGenericMapper<E, D> genericMapper;
    public Set<D> findAll() {
        return genericMapper.toDtos(new HashSet<>(genericRepository.findAll()));
    }

    public Optional<D> getById(Long id) {
        return genericRepository.findById(id).map(genericMapper::toDto);
    }

    public D create(D dto) {
        E savedEntity = genericRepository.save(genericMapper.toEntity(dto));
        return genericMapper.toDto(savedEntity);
    }

    public Optional<D> update(D dto) {
        return genericRepository.findById(dto.getId())
                .map(existingEntity -> {
                    genericMapper.updateEntity(dto, existingEntity);
                    return genericMapper.toDto(genericRepository.save(existingEntity));
                });
    }

    public Optional<D> delete(Long id) {
        Optional<D> dtoById = getById(id);
        dtoById.ifPresent(projectDto -> genericRepository.deleteById(id));

        return dtoById;
    }
}
