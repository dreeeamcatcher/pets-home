package mates.petshome.dto;

import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import mates.petshome.model.AnimalType;

@Getter
@Setter
public class ResponseAnimalPostDto {
    private String ownerName;
    private String ownerContactPhone;
    private String name;
    private String age;
    private AnimalType animalType;
    private String gender;
    private String location;
    private String description;
    private Set<ImageModelDto> postImages;
}
