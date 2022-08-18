package com.aluraflix.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VideoResponseDTO {

    private Long videoId;
    private String title;
    private String description;
    private String url;
}
