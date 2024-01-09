package mates.petshome.service;

import java.util.List;
import mates.petshome.dto.RequestAnimalPostDto;
import mates.petshome.dto.ResponseAnimalPostDto;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface AnimalService {
    List<ResponseAnimalPostDto> getAllWithImages(Pageable pageable);

    ResponseAnimalPostDto save(RequestAnimalPostDto animalPostDto, MultipartFile[] images);

    ResponseAnimalPostDto getById(Long id);
}
