package mates.petshome.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import mates.petshome.model.AnimalType;
import mates.petshome.model.Gender;

@Getter
@Setter
@RequiredArgsConstructor
public class RequestAnimalPostDto {
    @NotNull
    private String ownerName;
    @NotNull
    private String ownerContactPhone;
    @NotNull
    private String name;
    @NotNull
    private String age;
    @NotNull
    private AnimalType animalType;
    @NotNull
    private Gender gender;
    @NotNull
    private String location;
    @NotNull
    private String description;
}
