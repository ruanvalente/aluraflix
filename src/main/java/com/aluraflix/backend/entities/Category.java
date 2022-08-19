package com.aluraflix.backend.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "category")
public class Category {
    private static final String SEQUENCE = "seq_category";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE, allocationSize = 1)
    @Column(name = "id")

    private Long id;

    @NotBlank
    @NotNull
    @Column(name = "title")
    private String title;


    @NotBlank
    @NotNull
    @Column(name = "color")
    private String color;
}
