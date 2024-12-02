package com.example.IPL.Player.IPL.Config;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;

@Configuration
public class ModelConfig {
    @Bean
   public ModelMapper get(){
        return new ModelMapper();
    }
}
