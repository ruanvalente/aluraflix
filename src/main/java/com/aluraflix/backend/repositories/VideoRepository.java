package com.aluraflix.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aluraflix.backend.entities.Video;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
}
