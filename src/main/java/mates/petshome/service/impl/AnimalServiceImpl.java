package mates.petshome.service.impl;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import mates.petshome.dto.AnimalPostSearchParameters;
import mates.petshome.dto.PageDto;
import mates.petshome.dto.RequestAnimalPostDto;
import mates.petshome.dto.ResponseAnimalPostDto;
import mates.petshome.exception.EntityNotFoundException;
import mates.petshome.mapper.AnimalPostMapper;
import mates.petshome.model.AdoptAnimalForm;
import mates.petshome.model.AnimalPost;
import mates.petshome.model.ImageModel;
import mates.petshome.repository.animalpost.AnimalPostRepository;
import mates.petshome.repository.animalpost.AnimalPostSpecificationBuilder;
import mates.petshome.service.AnimalService;
import mates.petshome.service.EmailService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {
    private final AnimalPostSpecificationBuilder animalPostSpecificationBuilder;
    private final AnimalPostRepository animalPostRepository;
    private final AnimalPostMapper animalPostMapper;
    private final EmailService emailService;

    @Override
    public PageDto getAllWithImages(Pageable pageable) {
        Page<AnimalPost> animalPostPage = animalPostRepository.findAllWithImages(pageable);
        long totalElements = animalPostPage.getTotalElements();
        List<ResponseAnimalPostDto> content = animalPostPage.stream()
                .map(animalPostMapper::toDto)
                .toList();
        return new PageDto(content, totalElements);
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
                .orElseThrow(() -> new EntityNotFoundException("Can't find post by id = " + id));
        return animalPostMapper.toDto(animalPost);
    }

    @Override
    public void adoptAnimal(Long id, AdoptAnimalForm form) {
        emailService.notifyAboutNewAdoptRequest(id, form);
    }

    @Override
    public PageDto search(
            AnimalPostSearchParameters parameters,
            Pageable pageable
    ) {
        Specification<AnimalPost> spec = animalPostSpecificationBuilder.build(parameters);
        Page<AnimalPost> animalPostPage = animalPostRepository.findAll(spec, pageable);
        long totalElements = animalPostRepository.count(spec);
        List<ResponseAnimalPostDto> content = animalPostPage.stream()
                .map(animalPostMapper::toDto)
                .toList();
        return new PageDto(content, totalElements);
    }

    @Override
    public void deleteAnimalPost(Long id) {
        animalPostRepository.deleteById(id);
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



