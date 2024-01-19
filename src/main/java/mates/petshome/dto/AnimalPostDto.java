package mates.petshome.dto;

import lombok.Getter;
import lombok.Setter;
import mates.petshome.model.AnimalType;

@Getter
@Setter
public class AnimalPostDto {
    private Long id;
    private String contactPhone;
    private String text;
    private String imageUrl;
    private AnimalType animalType;
    private String location;
}
