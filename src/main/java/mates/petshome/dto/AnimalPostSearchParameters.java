package mates.petshome.dto;

public record AnimalPostSearchParameters(String[] age, String[] animalType,
                                         String[] gender, String[] location) {
}
