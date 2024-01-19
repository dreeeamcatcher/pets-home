package mates.petshome.service;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import mates.petshome.dto.RequestAnimalPostDto;
import mates.petshome.dto.ResponseAnimalPostDto;
import mates.petshome.mapper.AnimalPostMapper;
import mates.petshome.model.AdoptAnimalForm;
import mates.petshome.model.AnimalPost;
import mates.petshome.model.ImageModel;
import mates.petshome.repository.AnimalPostRepository;
import mates.petshome.specification.AnimalPostSpecifications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {
    private final AnimalPostRepository animalPostRepository;
    private final AnimalPostMapper animalPostMapper;
    private final EmailService emailService;

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

    @Override
    public void adoptAnimal(Long id, AdoptAnimalForm form) {
        emailService.notifyAboutNewAdoptRequest(id, form);
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

    @Override
    public Page<AnimalPost> getAllFiltered(int age, String animalType, String gender,
                                           String location, Pageable pageable) {
        return animalPostRepository.findAll(
                AnimalPostSpecifications.hasAge(age)
                        .and(AnimalPostSpecifications.hasAnimalType(animalType))
                        .and(AnimalPostSpecifications.hasGender(gender))
                        .and(AnimalPostSpecifications.hasLocation(location)),
                pageable
        );
    }
}



