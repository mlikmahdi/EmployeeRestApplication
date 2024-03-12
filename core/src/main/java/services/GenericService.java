package services;

import dto.IGenericDto;
import entities.GenericEntity;
import entities.find.FindEntity;
import execptions.ElementAlreadyExistsException;
import execptions.ElementNotFoundException;
import lombok.AllArgsConstructor;
import mappers.IGenericMapper;
import org.springframework.transaction.annotation.Transactional;
import repositories.IGenericRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Transactional
@AllArgsConstructor
public abstract class GenericService<E extends GenericEntity, D extends IGenericDto> {

    private final FindEntity<E> findEntity;

    private final IGenericRepository<E> genericRepository;

    private final IGenericMapper<E, D> genericMapper;
    public Set<D> findAll() {
        return genericMapper.toDtos(new HashSet<>(genericRepository.findAll()));
    }

    public Optional<D> getBy(String id) {
        return findEntity.by(id).map(genericMapper::toDto);
    }

    public D create(D dto) {
        findEntity.by(dto.id())
                .ifPresent(existing -> {
                    throw new ElementAlreadyExistsException(dto.id());
                });

        E savedEntity = genericRepository.save(genericMapper.toEntity(dto));

        return genericMapper.toDto(savedEntity);
    }

    public Optional<D> update(D dto) {
        return findEntity.by(dto.id())
                .map(existingEntity -> {
                    genericMapper.updateEntity(dto, existingEntity);
                    return genericMapper.toDto(genericRepository.save(existingEntity));
                });
    }

    public D delete(String id) {
        return findEntity.by(id)
                .map(entity -> {
                    genericRepository.deleteById(entity.getId());
                    return genericMapper.toDto(entity);
                })
                .orElseThrow(() -> new ElementNotFoundException(id));
    }
}
