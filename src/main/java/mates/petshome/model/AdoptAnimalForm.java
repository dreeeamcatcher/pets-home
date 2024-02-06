package mates.petshome.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private String name;
    @NotNull
    private String contactPhone;
    @NotNull
    private String message;
}
