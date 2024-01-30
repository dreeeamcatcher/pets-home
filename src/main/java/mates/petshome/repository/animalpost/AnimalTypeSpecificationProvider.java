package mates.petshome.repository.animalpost;

import lombok.RequiredArgsConstructor;
import mates.petshome.model.AnimalPost;
import mates.petshome.model.AnimalType;
import mates.petshome.repository.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AnimalTypeSpecificationProvider implements SpecificationProvider<AnimalPost> {
    @Override
    public String getKey() {
        return "animalType";
    }

    @Override
    public Specification<AnimalPost> getSpecification(String[] params) {
        try {
            AnimalType animalType = AnimalType.valueOf(params[0].toUpperCase());
            return ((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("animalType"), animalType));
        } catch (IllegalArgumentException e) {
            return (((root, query, criteriaBuilder) -> criteriaBuilder.and()));
        }
    }
}
