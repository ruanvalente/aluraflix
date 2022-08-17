package com.aluraflix.backend.resources;

import com.aluraflix.backend.dtos.VideoRequestDTO;
import com.aluraflix.backend.dtos.VideoResponseDTO;
import com.aluraflix.backend.entities.Video;
import com.aluraflix.backend.events.ResourceCreatedEvent;
import com.aluraflix.backend.resources.services.VideoResourcesService;
import org.springframework.context.ApplicationEventPublisher;
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
    private final ApplicationEventPublisher publisher;


    public VideoResource(VideoResourcesService service, ApplicationEventPublisher publisher) {
        this.service = service;
        this.publisher = publisher;
    }

//    @ApiOperation(value = "Retorna todas as intercorrências")
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Video>> findAll() {
        List<Video> intercorrenciaList = service.findAll();
        return ResponseEntity.ok().body(intercorrenciaList);
    }


//    @ApiOperation(value = "Retorna uma intercorrência por ID")
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<VideoResponseDTO> findById(@PathVariable Long id){
        VideoResponseDTO videoResponse = service.findById(id);
        return Objects.nonNull(videoResponse)
                ? ResponseEntity.ok(videoResponse)
                : ResponseEntity.notFound().build();
    }

//    @ApiOperation(value = "Cria uma nova intercorrência")
    @PostMapping(produces = "application/json")
    public ResponseEntity<VideoResponseDTO> save (@Valid @RequestBody VideoRequestDTO videoRequest, HttpServletResponse response){
        VideoResponseDTO videoResponse = service.save(videoRequest);
        publisher.publishEvent(new ResourceCreatedEvent(this, response, videoResponse.getVideoId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(videoResponse);
    }

//    @ApiOperation(value = "Edita uma intercorrência por ID")
    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<VideoResponseDTO> update (@PathVariable Long id, @Valid @RequestBody VideoRequestDTO videoRequest){
        VideoResponseDTO videoResponse = service.update(id, videoRequest);
        return ResponseEntity.ok(videoResponse);
    }
//    @ApiOperation(value = "Remove uma intercorrência por ID")
    @DeleteMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
