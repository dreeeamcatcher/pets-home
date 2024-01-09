package group_projetc.petshome.controller;

import group_projetc.petshome.dto.RequestAnimalPostDto;
import group_projetc.petshome.dto.ResponseAnimalPostDto;
import group_projetc.petshome.service.AnimalService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/animal_posts")
public class AnimalPostController {
    private final AnimalService animalService;

    @GetMapping
    public List<ResponseAnimalPostDto> getAll(Pageable pageable) {
        return animalService.getAllWithImages(pageable);
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseAnimalPostDto createAnimalPost(
            @RequestPart("post") RequestAnimalPostDto requestAnimalPostDto,
            @RequestPart("images") MultipartFile[] images
    ) {
        return animalService.save(requestAnimalPostDto, images);
    }

    @GetMapping("/{id}")
    public ResponseAnimalPostDto getAnimalPostById(@PathVariable Long id) {
        return animalService.getById(id);
    }

}
