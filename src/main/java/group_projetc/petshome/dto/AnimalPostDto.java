package group_projetc.petshome.dto;

import group_projetc.petshome.model.AnimalType;
import jakarta.persistence.Column;

public class AnimalPostDto {
    private Long id;
    private String contactPhone;
    private String text;
    private String imageUrl;
    private AnimalType animalType;
    private String location;
}
