package mates.petshome.service;

import mates.petshome.dto.AnimalPostDto;
import mates.petshome.model.AnimalPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface AnimalService {
    List<AnimalPostDto> getAll(Pageable pageable);
    AnimalPostDto save(AnimalPostDto animalPostDto);
    Page<AnimalPost> getAllFiltered(int age, String animalType, String gender, String location, Pageable pageable);
}
