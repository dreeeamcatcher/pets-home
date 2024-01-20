package mates.petshome.repository.animalpost;

import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import mates.petshome.model.AnimalPost;
import mates.petshome.repository.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpperAgeSpecificationProvider implements SpecificationProvider<AnimalPost> {
    @Override
    public String getKey() {
        return "upperAge";
    }

    @Override
    public Specification<AnimalPost> getSpecification(String[] params) {
        BigDecimal upperAge = BigDecimal.valueOf(Long.parseLong(params[0]));
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.lessThan(root.get("age"), upperAge));
    }
}
