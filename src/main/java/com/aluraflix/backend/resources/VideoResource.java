package com.aluraflix.backend.resources;

import com.aluraflix.backend.dtos.VideoRequestDTO;
import com.aluraflix.backend.dtos.VideoResponseDTO;
import com.aluraflix.backend.entities.Video;
import com.aluraflix.backend.resources.services.VideoResourcesService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/videos")
public class VideoResource {

    private final VideoResourcesService service;

    public VideoResource(VideoResourcesService service) {
        this.service = service;
    }

    @ApiOperation(value = "Retorna todas os vídeos.")
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Video>> findAll() {
        List<Video> videoList = service.findAll();
        return ResponseEntity.ok().body(videoList);
    }

    @ApiOperation(value = "Retorna um vídeo por ID")
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<VideoResponseDTO> findById(@PathVariable Long id){
        VideoResponseDTO videoResponse = service.findById(id);
        return Objects.nonNull(videoResponse)
                ? ResponseEntity.ok(videoResponse)
                : ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Busca um vídeo por titulo")
    @GetMapping(produces = "application/json")
    @RequestMapping(method = RequestMethod.GET, params = {"search"})
    public ResponseEntity<VideoResponseDTO> findByTitle(@RequestParam String search){
        VideoResponseDTO videoResponse = service.findByTitle(search);
        return Objects.nonNull(videoResponse)
                ? ResponseEntity.ok(videoResponse)
                : ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Cria um novo vídeo")
    @PostMapping(produces = "application/json")
    public ResponseEntity<VideoResponseDTO> save (@Valid @RequestBody VideoRequestDTO videoRequest, HttpServletResponse response){
        VideoResponseDTO videoResponse = service.save(videoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(videoResponse);
    }

    @ApiOperation(value = "Edita um vídeo por ID")
    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<VideoResponseDTO> update (@PathVariable Long id, @Valid @RequestBody VideoRequestDTO videoRequest){
        VideoResponseDTO videoResponse = service.update(id, videoRequest);
        return ResponseEntity.ok(videoResponse);
    }
    @ApiOperation(value = "Remove um vídeo por ID")
    @DeleteMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
