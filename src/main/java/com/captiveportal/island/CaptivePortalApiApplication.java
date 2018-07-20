package com.captiveportal.island;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EntityScan("com.carnival.utility.model")
@PropertySource("file:${ISLAND_CAPTIVE_PROP_PATH}/application-${SPRING_PROFILES_ACTIVE}.properties")
public class CaptivePortalApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(CaptivePortalApiApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
