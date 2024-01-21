package mates.petshome.repository.animalpost;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mates.petshome.model.AnimalPost;
import mates.petshome.repository.SpecificationProvider;
import mates.petshome.repository.SpecificationProviderManager;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AnimalPostSpecificationProviderManager
        implements SpecificationProviderManager<AnimalPost> {
    private final List<SpecificationProvider<AnimalPost>> animalPostSpecificationProviders;

    @Override
    public SpecificationProvider<AnimalPost> getSpecificationProvider(String key) {
        return animalPostSpecificationProviders.stream()
                .filter(p -> p.getKey().equals(key))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(
                        "Can't find SpecificationProvider for key = " + key));
    }
}
