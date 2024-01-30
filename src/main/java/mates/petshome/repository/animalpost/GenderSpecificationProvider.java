package mates.petshome.repository.animalpost;

import lombok.RequiredArgsConstructor;
import mates.petshome.model.AnimalPost;
import mates.petshome.model.Gender;
import mates.petshome.repository.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GenderSpecificationProvider implements SpecificationProvider<AnimalPost> {
    @Override
    public String getKey() {
        return "gender";
    }

    @Override
    public Specification<AnimalPost> getSpecification(String[] params) {
        try {
            Gender gender = Gender.valueOf(params[0].toUpperCase());
            return ((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("gender"), gender));
        } catch (IllegalArgumentException e) {
            return (((root, query, criteriaBuilder) -> criteriaBuilder.and()));
        }
    }
}
