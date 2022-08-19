package com.aluraflix.backend.resources;

import com.aluraflix.backend.dtos.CategoryRequestDTO;
import com.aluraflix.backend.dtos.CategoryResponseDTO;
import com.aluraflix.backend.dtos.VideoRequestDTO;
import com.aluraflix.backend.dtos.VideoResponseDTO;
import com.aluraflix.backend.entities.Category;
import com.aluraflix.backend.entities.Video;
import com.aluraflix.backend.resources.services.CategoryResourcesService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    private final CategoryResourcesService service;


    public CategoryResource(CategoryResourcesService service) {
        this.service = service;
    }

//    @ApiOperation(value = "Retorna todas os vídeos.")
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categories = service.findAll();
        return ResponseEntity.ok().body(categories);
    }


//    @ApiOperation(value = "Retorna um vídeo por ID")
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<CategoryResponseDTO> findById(@PathVariable Long id){
        CategoryResponseDTO categoryResponse = service.findById(id);
        return Objects.nonNull(categoryResponse)
                ? ResponseEntity.ok(categoryResponse)
                : ResponseEntity.notFound().build();
    }

//    @ApiOperation(value = "Cria um novo vídeo")
    @PostMapping(produces = "application/json")
    public ResponseEntity<CategoryResponseDTO> save (@Valid @RequestBody CategoryRequestDTO categoryRequest, HttpServletResponse response){
        CategoryResponseDTO categoryResponse = service.save(categoryRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryResponse);
    }

//    @ApiOperation(value = "Edita um vídeo por ID")
    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<CategoryResponseDTO> update (@PathVariable Long id, @Valid @RequestBody CategoryRequestDTO categoryRequest){
        CategoryResponseDTO categoryResponse = service.update(id, categoryRequest);
        return ResponseEntity.ok(categoryResponse);
    }
//    @ApiOperation(value = "Remove um vídeo por ID")
    @DeleteMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
