package mates.petshome.repository.animalpost;

import mates.petshome.model.AnimalPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalPostRepository extends JpaRepository<AnimalPost, Long>,
        JpaSpecificationExecutor<AnimalPost> {
    @Query(value = "FROM AnimalPost ap left join fetch ap.postImages im",
            countQuery = "SELECT COUNT(ap) FROM AnimalPost ap")
    Page<AnimalPost> findAllWithImages(Pageable pageable);
}
