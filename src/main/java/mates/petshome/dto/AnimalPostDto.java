package group_projetc.petshome.dto;

import group_projetc.petshome.model.AnimalType;
import lombok.Getter;
import lombok.Setter;

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
