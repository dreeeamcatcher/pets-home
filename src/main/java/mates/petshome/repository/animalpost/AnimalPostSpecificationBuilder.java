package mates.petshome.repository.animalpost;

import lombok.RequiredArgsConstructor;
import mates.petshome.dto.AnimalPostSearchParameters;
import mates.petshome.model.AnimalPost;
import mates.petshome.repository.SpecificationBuilder;
import mates.petshome.repository.SpecificationProviderManager;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AnimalPostSpecificationBuilder implements SpecificationBuilder<AnimalPost> {
    private final SpecificationProviderManager<AnimalPost> animalPostSpecificationProviderManager;

    @Override
    public Specification<AnimalPost> build(AnimalPostSearchParameters searchParameters) {
        Specification<AnimalPost> spec = Specification.where(null);
        if (searchParameters.lowerAge() != null) {
            spec = spec.and(
                    animalPostSpecificationProviderManager.getSpecificationProvider("lowerAge")
                            .getSpecification(searchParameters.lowerAge()));
        }
        if (searchParameters.upperAge() != null) {
            spec = spec.and(
                    animalPostSpecificationProviderManager.getSpecificationProvider("upperAge")
                            .getSpecification(searchParameters.upperAge()));
        }
        if (searchParameters.animalType() != null) {
            spec = spec.and(
                    animalPostSpecificationProviderManager.getSpecificationProvider("animalType")
                            .getSpecification(searchParameters.animalType()));
        }
        if (searchParameters.gender() != null) {
            spec = spec.and(
                    animalPostSpecificationProviderManager.getSpecificationProvider("gender")
                            .getSpecification(searchParameters.gender()));
        }
        if (searchParameters.location() != null) {
            spec = spec.and(
                    animalPostSpecificationProviderManager.getSpecificationProvider("location")
                            .getSpecification(searchParameters.location()));
        }
        return spec;
    }
}
