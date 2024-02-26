package com.LaEsquina.CebiSystemHub.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer{
	
	public void addCorsMapping(CorsRegistry registrer) {
		registrer.addMapping("/**").
		allowedOrigins("*").
		allowedMethods("*");
	}

}
