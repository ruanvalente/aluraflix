package com.aluraflix.backend.mappers;

import com.aluraflix.backend.dtos.CategoryRequestDTO;
import com.aluraflix.backend.dtos.CategoryResponseDTO;
import com.aluraflix.backend.entities.Category;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true)
    })
    Category sourceToDestination (CategoryRequestDTO categoryRequestDTO);

    @InheritInverseConfiguration
    CategoryResponseDTO destinationToSource (final Category category);

    @Mapping(target = "id", ignore = true)
    void updateSourceToDestination (CategoryRequestDTO categoryRequestDTO, @MappingTarget Category category);

    List<CategoryRequestDTO> map (List<Category> categoryList);
}
