package mates.petshome.controller;

import mates.petshome.dto.AnimalPostDto;
import mates.petshome.model.AnimalPost;
import mates.petshome.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/animal_post")
public class AnimalPostController {
    private final AnimalService animalService;

    @GetMapping
    public List<AnimalPostDto> getAll(Pageable pageable) {
        return animalService.getAll(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AnimalPostDto createAnimalPost(@RequestBody AnimalPostDto animalPostDto) {
        return animalService.save(animalPostDto);
    }

    @GetMapping("/filtered")
    public Page<AnimalPost> getFilteredAnimalPosts(
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) String animalType,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) String location,
            Pageable pageable) {
        return animalService.getAllFiltered(age, animalType, gender, location, pageable);
    }


}
