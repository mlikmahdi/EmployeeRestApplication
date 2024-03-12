package entities.find;

import java.util.Optional;

@FunctionalInterface
public interface FindEntity<E> {
    Optional<E> by(String id);
}
