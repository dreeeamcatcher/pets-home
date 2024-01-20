package mates.petshome.service;

import java.util.List;
import mates.petshome.dto.RequestAnimalPostDto;
import mates.petshome.dto.ResponseAnimalPostDto;
import mates.petshome.model.AdoptAnimalForm;
import mates.petshome.model.AnimalPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface AnimalService {
    List<ResponseAnimalPostDto> getAllWithImages(Pageable pageable);

    ResponseAnimalPostDto save(RequestAnimalPostDto animalPostDto, MultipartFile[] images);

    ResponseAnimalPostDto getById(Long id);

    void adoptAnimal(Long id, AdoptAnimalForm form);

    Page<AnimalPost> getAllFiltered(int age, String animalType, String gender, String location,
                                    Pageable pageable);
}
