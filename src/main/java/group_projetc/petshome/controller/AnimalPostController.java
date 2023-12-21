package group_projetc.petshome.controller;

import group_projetc.petshome.dto.AnimalPostDto;
import group_projetc.petshome.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
