package mates.petshome.repository.animalpost;

import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import mates.petshome.model.AnimalPost;
import mates.petshome.repository.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LowerAgeSpecificationProvider implements SpecificationProvider<AnimalPost> {
    @Override
    public String getKey() {
        return "lowerAge";
    }

    @Override
    public Specification<AnimalPost> getSpecification(String[] params) {
        BigDecimal lowerAge = BigDecimal.valueOf(Long.parseLong(params[0]));
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("age"), lowerAge));
    }
}
