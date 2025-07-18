package com.misa.gateway.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsGlobalConfiguration {

	@Bean
	CorsWebFilter corsWebFilter() {
		CorsConfiguration configurations = new CorsConfiguration();
		configurations.addAllowedOrigin("http://localhost:4200/");
		configurations.addAllowedHeader("*");
		configurations.addAllowedMethod("*");

		configurations.setAllowCredentials(true);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

		source.registerCorsConfiguration("/**", configurations);
		return new CorsWebFilter(source);
	}
	
}
