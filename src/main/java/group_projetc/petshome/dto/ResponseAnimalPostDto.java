package group_projetc.petshome.dto;

import group_projetc.petshome.model.AnimalType;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

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
