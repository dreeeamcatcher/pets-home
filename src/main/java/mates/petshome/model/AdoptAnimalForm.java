package mates.petshome.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class AdoptAnimalForm {
    @Id
    private Long id;
    private String name;
    private String contactPhone;
    private String message;
}
