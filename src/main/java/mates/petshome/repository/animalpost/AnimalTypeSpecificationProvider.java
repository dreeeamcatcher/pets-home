package mates.petshome.repository.animalpost;

import lombok.RequiredArgsConstructor;
import mates.petshome.model.AnimalPost;
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
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("animalType"), params[0].toUpperCase()));
    }
}
