package controllers;

import dto.IGenericDto;
import entities.GenericEntity;
import execptions.ElementNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import services.GenericService;

import java.util.Set;

@AllArgsConstructor
public abstract class GenericRestController<E extends GenericEntity, D extends IGenericDto> implements IGenericRestControllerApi<D> {

    private final GenericService<E, D> genericService;

    @Override
    @GetMapping
    @PreAuthorize("hasRole('DEV')")
    public ResponseEntity<Set<D>> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(genericService.findAll());
    }

    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('DEV')")
    public ResponseEntity<D> getOne(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(genericService.getBy(id).orElseThrow(() -> new ElementNotFoundException(id)));
    }

    @Override
    @PostMapping
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<D> create(@RequestBody D dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(genericService.create(dto));
    }

    @Override
    @PutMapping
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<D> update(@RequestBody D dto) {
        D body = genericService.update(dto).orElseThrow(() -> new ElementNotFoundException(dto.id()));
        return ResponseEntity.status(HttpStatus.OK)
                .body(body);
    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<D> delete(@PathVariable String id) {
        D body = genericService.delete(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(body);
    }
}
