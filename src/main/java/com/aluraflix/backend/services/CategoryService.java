package com.aluraflix.backend.services;

import com.aluraflix.backend.entities.Category;
import com.aluraflix.backend.entities.Video;
import com.aluraflix.backend.repositories.CategoryRepository;
import com.aluraflix.backend.repositories.VideoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {this.repository = repository;}

    @Transactional
    public List<Category> findAll(){
        return repository.findAll();
    }

    @Transactional
    public Category save (Category category) {return this.repository.save(category);}

    @Transactional
    public Category findById(Long id) {return this.repository.findById(id).orElse(null);}

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
