package group_projetc.petshome.data;

import group_projetc.petshome.model.AnimalPost;
import group_projetc.petshome.model.AnimalType;
import group_projetc.petshome.repository.AnimalPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final AnimalPostRepository animalPostRepository;
    @Override
    public void run(String... args) throws Exception {
        AnimalPost post1 = new AnimalPost();
        post1.setAnimalType(AnimalType.CAT);
        post1.setLocation("Kyiv");
        post1.setContactPhone("+38012 345 67 89");
        post1.setText("Funny cat");
        post1.setApproved(true);
        post1.setImageUrl("https://images.pexels.com/photos/45201/kitty-cat-kitten-pet-45201.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
        animalPostRepository.save(post1);

        AnimalPost post2 = new AnimalPost();
        post2.setAnimalType(AnimalType.DOG);
        post2.setLocation("Lviv");
        post2.setContactPhone("+38012 345 67 89");
        post2.setText("Funny dog");
        post2.setApproved(true);
        post2.setImageUrl("https://images.pexels.com/photos/58997/pexels-photo-58997.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
        animalPostRepository.save(post2);

        AnimalPost post3 = new AnimalPost();
        post3.setAnimalType(AnimalType.CAT);
        post3.setLocation("Kyiv");
        post3.setContactPhone("+38012 345 67 89");
        post3.setText("Looking for home!");
        post3.setApproved(false);
        post3.setImageUrl("https://images.pexels.com/photos/1543793/pexels-photo-1543793.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
        animalPostRepository.save(post3);

        AnimalPost post4 = new AnimalPost();
        post4.setAnimalType(AnimalType.DOG);
        post4.setLocation("Lviv");
        post4.setContactPhone("+38012 345 67 89");
        post4.setText("Hugs wanted!");
        post4.setApproved(false);
        post4.setImageUrl("https://images.pexels.com/photos/1490908/pexels-photo-1490908.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
        animalPostRepository.save(post4);
    }
}
