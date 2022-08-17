package com.aluraflix.backend.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"videoId"})
@ToString

@Entity
@Table(name = "video")
public class Video {
    private static final String SEQUENCE = "seq_intercorrencia";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE, allocationSize = 1)
    @Column(name = "id")
    private Long videoId;

    @NotBlank
    @NotNull
    @Column(name = "title")
    private String title;

    @NotBlank
    @NotNull
    @Column(name = "description")

    private String description;

    @NotBlank
    @NotNull
    @Column(name = "url")
    private String url;
}
