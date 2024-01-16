package mates.petshome.mapper;

import mates.petshome.dto.AnimalPostDto;
import mates.petshome.model.AnimalPost;
import org.mapstruct.Mapper;

@Mapper
public interface AnimalPostMapper {

    AnimalPostDto toDto(AnimalPost animalPost);
    AnimalPost toEntity(AnimalPostDto requestDto);
}
