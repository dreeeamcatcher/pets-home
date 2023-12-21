package group_projetc.petshome.mapper;

import group_projetc.petshome.dto.AnimalPostDto;
import group_projetc.petshome.model.AnimalPost;
import org.mapstruct.Mapper;

@Mapper
public interface AnimalPostMapper {

    AnimalPostDto toDto(AnimalPost animalPost);
}
