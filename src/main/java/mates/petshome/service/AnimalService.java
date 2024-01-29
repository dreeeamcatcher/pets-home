package mates.petshome.service;

import java.util.List;
import mates.petshome.dto.AnimalPostSearchParameters;
import mates.petshome.dto.RequestAnimalPostDto;
import mates.petshome.dto.ResponseAnimalPostDto;
import mates.petshome.model.AdoptAnimalForm;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface AnimalService {
    List<ResponseAnimalPostDto> getAllWithImages(Pageable pageable);

    ResponseAnimalPostDto save(RequestAnimalPostDto animalPostDto, MultipartFile[] images);

    ResponseAnimalPostDto getById(Long id);

    void adoptAnimal(Long id, AdoptAnimalForm form);

    List<ResponseAnimalPostDto> search(AnimalPostSearchParameters parameters);

    void deleteAnimalPost(Long id);
}
