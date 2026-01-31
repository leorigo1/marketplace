package leonardorigo.marketplace.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()).
		authorizeHttpRequests(auth -> auth
				.requestMatchers(
						"/h2-console/**",
					    "/swagger-ui/**",
					    "/v3/api-docs/**",
					    "/product/**"
						).permitAll()
				.requestMatchers(HttpMethod.GET, "/product/**").permitAll()
	            .requestMatchers(HttpMethod.POST, "/product/**").permitAll()
				.anyRequest().authenticated()
				)
		.headers(headers -> headers.frameOptions(frame -> frame.disable()));
		return http.build();	
	}	
}
