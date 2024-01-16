package mates.petshome.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "animals")
@Data
public class AnimalPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String contactPhone;
    private String text;
    private String imageUrl;
    @Column(nullable = false)
    private AnimalType animalType;
    private String location;
    @Column(nullable = false)
    private boolean isApproved;
    @Column(nullable = false)
    private boolean isDeleted;
}
