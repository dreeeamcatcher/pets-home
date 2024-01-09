package group_projetc.petshome.mapper;

import group_projetc.petshome.dto.RequestAnimalPostDto;
import group_projetc.petshome.dto.ResponseAnimalPostDto;
import group_projetc.petshome.model.AnimalPost;
import org.mapstruct.Mapper;

@Mapper(uses = ImageModelMapper.class)
public interface AnimalPostMapper {

    ResponseAnimalPostDto toDto(AnimalPost animalPost);

    AnimalPost toEntity(RequestAnimalPostDto requestDto);
}
