package group_projetc.petshome.service;

import group_projetc.petshome.dto.AnimalPostDto;
import group_projetc.petshome.mapper.AnimalPostMapper;
import group_projetc.petshome.model.AnimalPost;
import group_projetc.petshome.repository.AnimalPostRepository;
import lombok.RequiredArgsConstructor;
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

}
