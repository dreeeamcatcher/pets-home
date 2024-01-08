package group_projetc.petshome.repository;

import group_projetc.petshome.model.AnimalPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalPostRepository extends JpaRepository<AnimalPost, Long>, JpaSpecificationExecutor<AnimalPost> {
    Page<AnimalPost> findAll(Pageable pageable);
    AnimalPost save(AnimalPost animalPost);
}
