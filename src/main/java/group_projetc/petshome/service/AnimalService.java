package group_projetc.petshome.service;

import group_projetc.petshome.dto.RequestAnimalPostDto;
import group_projetc.petshome.dto.ResponseAnimalPostDto;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface AnimalService {
    List<ResponseAnimalPostDto> getAllWithImages(Pageable pageable);

    ResponseAnimalPostDto save(RequestAnimalPostDto animalPostDto, MultipartFile[] images);

    ResponseAnimalPostDto getById(Long id);
}
