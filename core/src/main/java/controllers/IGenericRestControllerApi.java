package controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Set;

public interface IGenericRestControllerApi<D> {

    @Operation(description = "Retourne tous les éléments")
    @ApiResponse(responseCode = "200", description = "Éléments trouvés",
            content = { @Content(mediaType = "application/json") })
    ResponseEntity<Set<D>> getAll();

    @Operation(description = "Retourne un élément par son ID")
    @ApiResponse(responseCode = "200", description = "Élément trouvé",
            content = { @Content(mediaType = "application/json") })
    ResponseEntity<D> getOne(@PathVariable Long id);

    @Operation(description = "Crée un élément")
    @ApiResponse(responseCode = "201", description = "Élément crée",
            content = { @Content(mediaType = "application/json") })
    ResponseEntity<D> create(@RequestBody D dto);

    @Operation(description = "Modifie un élément")
    @ApiResponse(responseCode = "200", description = "Élément modifié",
            content = { @Content(mediaType = "application/json") })
    ResponseEntity<D> update(@RequestBody D dto);

    @Operation(description = "Supprime un élément par son ID")
    @ApiResponse(responseCode = "200", description = "Élément supprimé")
    ResponseEntity<D> delete(@PathVariable Long id);
}
