package mates.petshome.repository.animalpost;

import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import mates.petshome.model.AnimalPost;
import mates.petshome.repository.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LocationSpecificationProvider implements SpecificationProvider<AnimalPost> {
    @Override
    public String getKey() {
        return "location";
    }

    @Override
    public Specification<AnimalPost> getSpecification(String[] params) {
        return ((root, query, criteriaBuilder) ->
                root.get("location").in(Arrays.stream(params)
                                                .map(p -> p.substring(0, 1)
                                                        .toUpperCase() + p.substring(1)
                                                        .toLowerCase())
                                                .toArray()));
    }
}
