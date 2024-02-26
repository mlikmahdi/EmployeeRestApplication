package services;

import dto.IGenericDto;
import entities.IGenericEntity;
import execptions.ElementNotFoundException;
import lombok.AllArgsConstructor;
import mappers.IGenericMapper;
import repositories.IGenericRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

@AllArgsConstructor
public abstract class GenericService<E extends IGenericEntity, D extends IGenericDto> {

    private final Function<String, Optional<E>> findEntity;

    private final IGenericRepository<E> genericRepository;

    private final IGenericMapper<E, D> genericMapper;
    public Set<D> findAll() {
        return genericMapper.toDtos(new HashSet<>(genericRepository.findAll()));
    }

    public Optional<D> getBy(String id) {
        return findEntity.apply(id).map(genericMapper::toDto);
    }

    public D create(D dto) {
        E savedEntity = genericRepository.save(genericMapper.toEntity(dto));
        return genericMapper.toDto(savedEntity);
    }

    public Optional<D> update(D dto) {
        return findEntity.apply(dto.id())
                .map(existingEntity -> {
                    genericMapper.updateEntity(dto, existingEntity);
                    return genericMapper.toDto(genericRepository.save(existingEntity));
                });
    }

    public D delete(String id) {
        return findEntity.apply(id).map(
                entity -> {
                    genericRepository.deleteById(entity.getId());
                    return genericMapper.toDto(entity);
                }
        ).orElseThrow(() -> new ElementNotFoundException(id));
    }
}
