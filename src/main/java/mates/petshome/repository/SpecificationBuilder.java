package mates.petshome.repository;

import mates.petshome.dto.AnimalPostSearchParameters;
import org.springframework.data.jpa.domain.Specification;

public interface SpecificationBuilder<T> {
    Specification<T> build(AnimalPostSearchParameters searchParameters);
}
