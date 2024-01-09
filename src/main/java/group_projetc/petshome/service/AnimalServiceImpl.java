package group_projetc.petshome.service;

import group_projetc.petshome.dto.RequestAnimalPostDto;
import group_projetc.petshome.dto.ResponseAnimalPostDto;
import group_projetc.petshome.mapper.AnimalPostMapper;
import group_projetc.petshome.model.AnimalPost;
import group_projetc.petshome.model.ImageModel;
import group_projetc.petshome.repository.AnimalPostRepository;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class AnimalServiceImpl implements AnimalService {
    private final AnimalPostRepository animalPostRepository;
    private final AnimalPostMapper animalPostMapper;

    @Override
    public List<ResponseAnimalPostDto> getAllWithImages(Pageable pageable) {
        return animalPostRepository.findAllWithImages(pageable)
                .stream()
                .map(animalPostMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseAnimalPostDto save(RequestAnimalPostDto request, MultipartFile[] images) {
        AnimalPost animalPost = animalPostMapper.toEntity(request);
        try {
            Set<ImageModel> imageModels = processImages(images);
            animalPost.setPostImages(imageModels);
        } catch (IOException e) {
            throw new RuntimeException("Can't read images", e);
        }
        return animalPostMapper.toDto(animalPostRepository.save(animalPost));
    }

    @Override
    public ResponseAnimalPostDto getById(Long id) {
        AnimalPost animalPost = animalPostRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can't find post by id = " + id));
        return animalPostMapper.toDto(animalPost);
    }

    private Set<ImageModel> processImages(MultipartFile[] images) throws IOException {
        Set<ImageModel> imageSet = new HashSet<>();
        for (MultipartFile image : images) {
            ImageModel imageModel = new ImageModel().setName(image.getOriginalFilename())
                    .setData(image.getBytes());
            imageSet.add(imageModel);
        }
        return imageSet;
    }
}
