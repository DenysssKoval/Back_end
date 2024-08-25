package de.ait.wordcard.configuration;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigurarion {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
