package mates.petshome.dto;

public record AnimalPostSearchParameters(String[] lowerAge, String[] upperAge, String[] animalType,
                                         String[] gender, String[] location) {
}
