package group_projetc.petshome.service;

import group_projetc.petshome.dto.AnimalPostDto;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface AnimalService {
    List<AnimalPostDto> getAll(Pageable pageable);
    AnimalPostDto save(AnimalPostDto animalPostDto);
}
