package mates.petshome.dto;

import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import mates.petshome.model.AnimalType;

@Getter
@Setter
public class ResponseAnimalPostDto {
    private String name;
    private int age;
    private AnimalType animalType;
    private String gender;
    private String contactPhone;
    private String description;
    private String location;
    private Set<ImageModelDto> postImages;
}
