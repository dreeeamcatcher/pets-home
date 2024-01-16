package mates.petshome.specification;

import mates.petshome.model.AnimalPost;
import org.springframework.data.jpa.domain.Specification;

public class AnimalPostSpecifications {
    public static Specification<AnimalPost> hasAge(int age) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("age"), age);
    }

    public static Specification<AnimalPost> hasAnimalType(String animalType) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("animalType"), animalType);
    }

    public static Specification<AnimalPost> hasGender(String gender) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("gender"), gender);
    }

    public static Specification<AnimalPost> hasLocation(String location) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("location"), location);
    }
}
