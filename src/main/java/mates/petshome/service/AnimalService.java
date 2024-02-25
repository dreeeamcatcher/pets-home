package mates.petshome.service;

import mates.petshome.dto.AnimalPostSearchParameters;
import mates.petshome.dto.PageDto;
import mates.petshome.dto.RequestAnimalPostDto;
import mates.petshome.dto.ResponseAnimalPostDto;
import mates.petshome.model.AdoptAnimalForm;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface AnimalService {
    PageDto getAllWithImages(Pageable pageable);

    ResponseAnimalPostDto save(RequestAnimalPostDto animalPostDto, MultipartFile[] images);

    ResponseAnimalPostDto getById(Long id);

    void adoptAnimal(Long id, AdoptAnimalForm form);

    PageDto search(AnimalPostSearchParameters parameters, Pageable pageable);

    void deleteAnimalPost(Long id);
}
