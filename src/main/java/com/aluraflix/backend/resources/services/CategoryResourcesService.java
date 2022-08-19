package com.aluraflix.backend.resources.services;

import com.aluraflix.backend.dtos.CategoryRequestDTO;
import com.aluraflix.backend.dtos.CategoryResponseDTO;
import com.aluraflix.backend.dtos.VideoRequestDTO;
import com.aluraflix.backend.dtos.VideoResponseDTO;
import com.aluraflix.backend.entities.Category;
import com.aluraflix.backend.entities.Video;
import com.aluraflix.backend.exceptions.AluraflixException;
import com.aluraflix.backend.mappers.CategoryMapper;
import com.aluraflix.backend.mappers.VideoMapper;
import com.aluraflix.backend.services.CategoryService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class CategoryResourcesService {

    private final CategoryService service;
    private final CategoryMapper mapper;

    public CategoryResourcesService(CategoryService service, CategoryMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public List<Category> findAll(){
        return service.findAll();
    }

    public CategoryResponseDTO findById(Long id) {
        if (Objects.isNull(id)){
            throw new AluraflixException(HttpStatus.PRECONDITION_FAILED, "Não foi possível realizar a operação. O ID é obrigatório");
        }
        Category category = service.findById(id);
        if (Objects.isNull(category)){
            throw new AluraflixException(HttpStatus.NOT_FOUND, "Não foi possível recuperar o recurso informado. Por favor contate o administrador do sistema.");

        }
        return mapper.destinationToSource(category);
    }

    public CategoryResponseDTO save(CategoryRequestDTO categoryRequestDTO) {
        Category categoryConverted = mapper.sourceToDestination(categoryRequestDTO);
        Category categorySaved = service.save(categoryConverted);
        return mapper.destinationToSource(categorySaved);
    }

    public CategoryResponseDTO update(Long id, CategoryRequestDTO categoryRequestDTO) {
        if (Objects.isNull(categoryRequestDTO.getTitle()) || Objects.isNull(categoryRequestDTO.getColor())) {
            throw new AluraflixException(HttpStatus.BAD_REQUEST, "Por favor, preencha todos os campos corretamente");
        }

        if (Objects.isNull(id)) {
            throw new AluraflixException(HttpStatus.PRECONDITION_FAILED, "Não foi possível realizar a operação. O ID é obrigatório");
        }

        Category categoryRecovered = service.findById(id);

        if (Objects.isNull(categoryRecovered)) {
            throw new EmptyResultDataAccessException(1);
        }
        mapper.updateSourceToDestination(categoryRequestDTO, categoryRecovered);
        return mapper.destinationToSource(service.save(categoryRecovered));
    }

    public void delete(Long id) {

        if (Objects.isNull(id)) {
            throw new AluraflixException(HttpStatus.PRECONDITION_FAILED, "Não foi possível exluir o vídeo informado. O campo ID não" +
                    " pode ser nulo.");
        }
        Category categoryRecovered = service.findById(id);
        if (Objects.isNull(categoryRecovered)) {
            throw new AluraflixException(HttpStatus.NOT_FOUND, "Não foi possível recuperar o recurso informado. Por favor contate o administrador do sistema.");
        }
        service.delete(id);
    }

}
