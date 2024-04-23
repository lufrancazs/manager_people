package br.com.lucasfranca.managerpeople.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelConfig {

    @Bean
    ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
