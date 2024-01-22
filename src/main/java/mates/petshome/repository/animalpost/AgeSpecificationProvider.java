package mates.petshome.repository.animalpost;

import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import mates.petshome.model.AnimalPost;
import mates.petshome.repository.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AgeSpecificationProvider implements SpecificationProvider<AnimalPost> {
    @Override
    public String getKey() {
        return "age";
    }

    @Override
    public Specification<AnimalPost> getSpecification(String[] params) {
        return ((root, query, criteriaBuilder) ->
                root.get("age").in(Arrays.stream(params).toArray()));
    }
}
