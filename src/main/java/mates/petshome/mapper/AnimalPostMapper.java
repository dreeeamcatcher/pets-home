package mates.petshome.mapper;

import mates.petshome.dto.RequestAnimalPostDto;
import mates.petshome.dto.ResponseAnimalPostDto;
import mates.petshome.model.AnimalPost;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = ImageModelMapper.class)
public interface AnimalPostMapper {

    ResponseAnimalPostDto toDto(AnimalPost animalPost);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "postImages", ignore = true)
    @Mapping(target = "approved", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    AnimalPost toEntity(RequestAnimalPostDto requestDto);
}
