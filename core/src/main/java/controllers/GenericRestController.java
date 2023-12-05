package controllers;

import dto.IGenericDto;
import entities.IGenericEntity;
import execptions.ElementNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.GenericService;

import java.util.Set;

@AllArgsConstructor
public abstract class GenericRestController<E extends IGenericEntity, D extends IGenericDto> implements IGenericRestControllerApi<D> {

    private final GenericService<E, D> genericService;

    @Override
    @GetMapping("/all")
    public ResponseEntity<Set<D>> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(genericService.findAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<D> getOne(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(genericService.getById(id).orElseThrow(() -> new ElementNotFoundException(id)));
    }

    @Override
    @PostMapping("/new")
    public ResponseEntity<D> create(@RequestBody D dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(genericService.create(dto));
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<D> update(@RequestBody D dto) {
        D body = genericService.update(dto).orElseThrow(() -> new ElementNotFoundException(dto.getId()));
        return ResponseEntity.status(HttpStatus.OK)
                .body(body);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<D> delete(@PathVariable Long id) {
        D body = genericService.delete(id).orElseThrow(() -> new ElementNotFoundException(id));
        return ResponseEntity.status(HttpStatus.OK)
                .body(body);
    }
}
