package com.infy.InStepPlatform;

import com.infy.InStepPlatform.configs.SpringSecurityAuditorAware;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef="auditorAware")
public class InStepPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(InStepPlatformApplication.class, args);
	}
	@Bean
	public AuditorAware<String> auditorAware() {return new SpringSecurityAuditorAware();}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public BCryptPasswordEncoder encoder() {return new BCryptPasswordEncoder();}
}
