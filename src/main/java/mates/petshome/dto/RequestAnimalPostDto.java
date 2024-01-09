package mates.petshome.dto;

import lombok.Getter;
import lombok.Setter;
import mates.petshome.model.AnimalType;

@Getter
@Setter
public class RequestAnimalPostDto {
    private String name;
    private int age;
    private AnimalType animalType;
    private String gender;
    private String contactPhone;
    private String description;
    private String location;
}
