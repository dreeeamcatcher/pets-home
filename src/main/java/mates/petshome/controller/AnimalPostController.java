package mates.petshome.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mates.petshome.dto.AnimalPostSearchParameters;
import mates.petshome.dto.PageDto;
import mates.petshome.dto.RequestAnimalPostDto;
import mates.petshome.dto.ResponseAnimalPostDto;
import mates.petshome.model.AdoptAnimalForm;
import mates.petshome.service.AnimalService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/animal_posts")
@CrossOrigin
@RequiredArgsConstructor
@Tag(name = "Animal Posts management")
public class AnimalPostController {
    private final AnimalService animalService;

    @Operation(summary = "Get all available animal posts")
    @GetMapping
    public PageDto getAll(Pageable pageable) {
        return animalService.getAllWithImages(pageable);
    }

    @Operation(summary = "Create animal post")
    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseAnimalPostDto createAnimalPost(
            @RequestPart("post") @Valid RequestAnimalPostDto requestAnimalPostDto,
            @RequestPart("images") MultipartFile[] images
    ) {
        return animalService.save(requestAnimalPostDto, images);
    }

    @Operation(summary = "Get animal post by id")
    @GetMapping("/{id}")
    public ResponseAnimalPostDto getAnimalPostById(@PathVariable Long id) {
        return animalService.getById(id);
    }

    @Operation(summary = "Create adopt request for a specific animal post")
    @PostMapping("/{id}/adopt")
    @ResponseStatus(HttpStatus.OK)
    public void adoptAnimal(@PathVariable Long id, @RequestBody @Valid AdoptAnimalForm form) {
        animalService.adoptAnimal(id, form);
    }

    @Operation(summary = "Search for animal posts using filters")
    @GetMapping("/search")
    public PageDto search(
            AnimalPostSearchParameters parameters,
            Pageable pageable
    ) {
        return animalService.search(parameters, pageable);
    }

    @Operation(summary = "Delete animal post by id")
    @DeleteMapping("/{id}")
    public void deleteAnimalPost(@PathVariable Long id) {
        animalService.deleteAnimalPost(id);
    }
}
