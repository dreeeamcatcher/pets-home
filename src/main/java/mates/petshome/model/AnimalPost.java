package mates.petshome.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "animals")
@Getter
@Setter
@RequiredArgsConstructor
public class AnimalPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String ownerName;
    @Column(nullable = false)
    private String ownerContactNumber;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String age;
    @Column(nullable = false)
    private AnimalType animalType;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private String contactPhone;
    @Column(nullable = false)
    private String description;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "animals_images", joinColumns = {@JoinColumn(name = "animal_id")},
            inverseJoinColumns = {@JoinColumn(name = "image_id")})
    private Set<ImageModel> postImages;
    private String location;
    @Column(nullable = false)
    private boolean isApproved = true;
    @Column(nullable = false)
    private boolean isDeleted;
}
