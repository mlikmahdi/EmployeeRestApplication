package mappers;

import org.mapstruct.MappingTarget;

import java.util.Set;

public interface IGenericMapper<E, D> {

    E toEntity(D dto);

    D toDto(E entity);

    Set<D> toDtos(Set<E> entities);

    void updateEntity(D dto, @MappingTarget E entity);
}
