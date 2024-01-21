package mates.petshome.repository.animalpost;

import lombok.RequiredArgsConstructor;
import mates.petshome.model.AnimalPost;
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
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("gender"), params[0].toLowerCase()));
    }
}
