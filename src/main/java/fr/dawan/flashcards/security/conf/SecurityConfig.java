package fr.dawan.flashcards.security.conf;

import fr.dawan.flashcards.security.interceptors.JwtFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	private final UserDetailsService userDetailsService;
	private final JwtFilter jwtFilter;
	// TODO : faire une map au lieu de plusieurs tableaux
	public static final String[] AUTHORIZED_URL = new String[] {
			"/",
			"/home",
			"/auth/**",
			"/public/**",
			"/api/v1/cards",
			"/api/v1/passages/**"
	};
	public static final Map<HttpMethod, String[]> AUTHORIZED_METHOD = Map.of(
		HttpMethod.GET,new String[] {
				"/api/v1/cards/**"
		},
		HttpMethod.POST,new String[] {
		
		},
		HttpMethod.PUT,new String[] {
		
		},
		HttpMethod.DELETE,new String[] {
		
		}
	);
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
		return authenticationConfiguration.getAuthenticationManager();
	}

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.cors(AbstractHttpConfigurer::disable)
				.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
						.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
						.requestMatchers(AUTHORIZED_URL).permitAll()
						.requestMatchers(HttpMethod.GET,AUTHORIZED_METHOD.get(HttpMethod.GET)).permitAll()
						.requestMatchers(HttpMethod.POST,AUTHORIZED_METHOD.get(HttpMethod.POST)).permitAll()
						.requestMatchers(HttpMethod.PUT,AUTHORIZED_METHOD.get(HttpMethod.PUT)).permitAll()
						.requestMatchers(HttpMethod.DELETE,AUTHORIZED_METHOD.get(HttpMethod.DELETE)).permitAll()
						.anyRequest().authenticated())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
				.userDetailsService(userDetailsService)
				.build();
    }
	
	@Bean
	public WebMvcConfigurer myMvcConfigurer() {
		
		return new WebMvcConfigurer() {
			
			// CORS ORIGIN
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:5173")
						.allowedMethods("*", "GET", "POST", "PUT", "DELETE", "OPTIONS").allowedHeaders("*");
			}
		};
	}
}
