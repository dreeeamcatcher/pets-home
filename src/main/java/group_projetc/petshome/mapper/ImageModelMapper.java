package group_projetc.petshome.mapper;

import group_projetc.petshome.dto.ImageModelDto;
import group_projetc.petshome.model.ImageModel;
import org.mapstruct.Mapper;

@Mapper
public interface ImageModelMapper {
    ImageModelDto toDto(ImageModel imageModel);
}
