package com.examen.fifa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import service.VoetbalService;
import service.VoetbalServiceImpl;
import validation.AankoopValidation;

@SpringBootApplication
public class FifaApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(FifaApplication.class, args);
	}
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("resources/css/");
        registry.addResourceHandler("/img/**").addResourceLocations("resources/img/");
    }
	
	@Bean
	public VoetbalService voetbalService() {
		return new VoetbalServiceImpl();
	}
	
	@Bean
	public AankoopValidation aankoopValidation() {
		return new AankoopValidation();
	}
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
		ms.setBasename("messages");
		return ms;
	}

}
