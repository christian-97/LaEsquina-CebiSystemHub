package com.LaEsquina.CebiSystemHub.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CorsConfig implements WebMvcConfigurer{
	
	public void addCorsMapping(CorsRegistry registrer) {
		registrer.addMapping("/**").
		allowedOrigins("*").
		allowedMethods("*");
	}

}
