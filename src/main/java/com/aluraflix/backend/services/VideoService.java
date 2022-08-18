package com.aluraflix.backend.services;

import com.aluraflix.backend.entities.Video;
import com.aluraflix.backend.repositories.VideoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VideoService {

    private final VideoRepository repository;

    public VideoService(VideoRepository repository) {this.repository = repository;}

    @Transactional
    public List<Video> findAll(){
        return repository.findAll();
    }

    @Transactional
    public Video save (Video video) {return this.repository.save(video);}

    @Transactional
    public Video findById(Long id) {return this.repository.findById(id).orElse(null);}

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
