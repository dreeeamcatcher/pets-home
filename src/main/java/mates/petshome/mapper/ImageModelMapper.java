package mates.petshome.mapper;

import mates.petshome.dto.ImageModelDto;
import mates.petshome.model.ImageModel;
import org.mapstruct.Mapper;

@Mapper
public interface ImageModelMapper {
    ImageModelDto toDto(ImageModel imageModel);
}
