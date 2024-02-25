package mates.petshome.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PageDto {
    private List<ResponseAnimalPostDto> content;
    private long totalItems;
}
