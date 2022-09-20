package com.example.clientsservicepd12.secure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.example.clientsservicepd12.models.User.*;
import static org.springframework.security.core.userdetails.User.*;

@Configuration
public class SecurityConfig {
	//@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public InMemoryUserDetailsManager userDetailsManager(/*BCryptPasswordEncoder encoder*/) {
		return new InMemoryUserDetailsManager(
			builder()
				//.passwordEncoder(encoder::encode)
				.username("u")
				.password("p")
				.roles(Role.USER.name())
				.build(),
			builder()
				//.passwordEncoder(encoder::encode)
				.username("a")
				.password("p")
				.roles(Role.ADMIN.name())
				.build()
		);
	}

	
}
