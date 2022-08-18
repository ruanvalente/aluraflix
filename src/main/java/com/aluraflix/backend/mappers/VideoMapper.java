package com.aluraflix.backend.mappers;

import com.aluraflix.backend.dtos.VideoRequestDTO;
import com.aluraflix.backend.dtos.VideoResponseDTO;
import com.aluraflix.backend.entities.Video;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VideoMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true)
    })
    Video sourceToDestination (VideoRequestDTO videoRequestDTO);

    @InheritInverseConfiguration
    VideoResponseDTO destinationToSource (final Video video);

    @Mapping(target = "id", ignore = true)
    void updateSourceToDestination (VideoRequestDTO videoRequestDTO, @MappingTarget Video video);

    List<VideoRequestDTO> map (List<Video> videoList);
}
