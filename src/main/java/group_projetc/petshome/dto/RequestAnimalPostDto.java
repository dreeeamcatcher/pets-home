package group_projetc.petshome.dto;

import group_projetc.petshome.model.AnimalType;
import lombok.Getter;
import lombok.Setter;

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
