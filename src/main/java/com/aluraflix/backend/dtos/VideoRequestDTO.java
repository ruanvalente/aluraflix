package com.aluraflix.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VideoRequestDTO {

    @NotBlank
    @NotNull
    private String title;
    @NotBlank
    @NotNull
    private String description;
    @NotBlank
    @NotNull
    private String url;
}
