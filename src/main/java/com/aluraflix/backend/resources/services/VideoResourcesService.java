package com.aluraflix.backend.resources.services;

import com.aluraflix.backend.dtos.VideoRequestDTO;
import com.aluraflix.backend.dtos.VideoResponseDTO;
import com.aluraflix.backend.entities.Video;
import com.aluraflix.backend.exceptions.AluraflixException;
import com.aluraflix.backend.mappers.VideoMapper;
import com.aluraflix.backend.services.CategoryService;
import com.aluraflix.backend.services.VideoService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class VideoResourcesService {

    private final VideoService service;
    private final VideoMapper mapper;

    public VideoResourcesService(VideoService service, VideoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public List<Video> findAll(){
        return service.findAll();
    }

    public VideoResponseDTO findById(Long id) {
        if (Objects.isNull(id)){
            throw new AluraflixException(HttpStatus.PRECONDITION_FAILED, "Não foi possível realizar a operação. O ID é obrigatório");
        }
        Video video = service.findById(id);
        if (Objects.isNull(video)){
            throw new AluraflixException(HttpStatus.NOT_FOUND, "Não foi possível recuperar o recurso informado. Por favor contate o administrador do sistema.");

        }
        return mapper.destinationToSource(video);
    }

    public VideoResponseDTO findByTitle(String title) {
        Video video = service.findByTitle(title);
        if (Objects.isNull(video)){
            throw new AluraflixException(HttpStatus.NOT_FOUND, "Não foi possível recuperar o recurso informado. Por favor contate o administrador do sistema.");

        }
        return mapper.destinationToSource(video);
    }

    public VideoResponseDTO save(VideoRequestDTO videoRequestDTO) {
        Video videoConverted =
                mapper.sourceToDestination(videoRequestDTO);
        Video videoSaved =
                service.save(videoConverted);
        return mapper.destinationToSource(videoSaved);
    }

    public VideoResponseDTO update(Long id, VideoRequestDTO videoRequestDTO) {
        if (Objects.isNull(id)) {
            throw new AluraflixException(HttpStatus.PRECONDITION_FAILED, "Não foi possível realizar a operação. O ID é obrigatório");
        }
        Video videoRecovered = service.findById(id);
        if (Objects.isNull(videoRecovered)) {
            throw new EmptyResultDataAccessException(1);
        }
        mapper.updateSourceToDestination(videoRequestDTO, videoRecovered);
        return mapper.destinationToSource(service.save(videoRecovered));
    }

    public void delete(Long id) {

        if (Objects.isNull(id)) {
            throw new AluraflixException(HttpStatus.PRECONDITION_FAILED, "Não foi possível exluir o vídeo informado. O campo ID não" +
                    " pode ser nulo.");
        }
        Video videoRecovered = service.findById(id);
        if (Objects.isNull(videoRecovered)) {
            throw new AluraflixException(HttpStatus.NOT_FOUND, "Não foi possível recuperar o recurso informado. Por favor contate o administrador do sistema.");
        }
        service.delete(id);
    }

}
