package mates.petshome.config;

import mates.petshome.mapper.AnimalPostMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappingConfig {

    @Bean
    public AnimalPostMapper animalPostMapper() {
        return Mappers.getMapper(AnimalPostMapper.class);
    }
}
