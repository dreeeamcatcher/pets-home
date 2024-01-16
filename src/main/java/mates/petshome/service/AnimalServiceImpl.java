package mates.petshome.service;

import mates.petshome.dto.AnimalPostDto;
import mates.petshome.mapper.AnimalPostMapper;
import mates.petshome.model.AnimalPost;
import mates.petshome.repository.AnimalPostRepository;
import mates.petshome.specification.AnimalPostSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AnimalServiceImpl implements AnimalService{
    private final AnimalPostRepository animalPostRepository;
    private final AnimalPostMapper animalPostMapper;

    @Override
    public List<AnimalPostDto> getAll(Pageable pageable) {
        return animalPostRepository.findAll(pageable).stream()
                .map(animalPostMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AnimalPostDto save(AnimalPostDto request) {
        AnimalPost animalPost = animalPostMapper.toEntity(request);
        return animalPostMapper.toDto(animalPostRepository.save(animalPost));
    }

    @Override
    public Page<AnimalPost> getAllFiltered(int age, String animalType, String gender, String location, Pageable pageable) {
        return animalPostRepository.findAll(
                AnimalPostSpecifications.hasAge(age)
                        .and(AnimalPostSpecifications.hasAnimalType(animalType))
                        .and(AnimalPostSpecifications.hasGender(gender))
                        .and(AnimalPostSpecifications.hasLocation(location)),
                pageable
        );
    }
}
