package mates.petshome.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import mates.petshome.model.AnimalType;

@Getter
@Setter
@RequiredArgsConstructor
public class RequestAnimalPostDto {
    private String ownerName;
    private String ownerContactPhone;
    private String name;
    private String age;
    private AnimalType animalType;
    private String gender;
    private String location;
    private String description;
}
