package fr.eni.projetPizza.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// @formatter:off
        http.authorizeHttpRequests((authorize) -> authorize
        		.requestMatchers("/Accueil", "/Carte", "/Panier", "/*.css", "/images/**").permitAll()
                .requestMatchers("/articles", "/Commande" ).hasAuthority("SERVEUR")
        		.requestMatchers("/Preparation").hasAuthority("PIZZAIOLLO")
                .anyRequest().authenticated()               
                )
        .formLogin(Customizer.withDefaults())      
                .formLogin((formLogin) -> formLogin
                	.loginPage("/seConnecter")
                	.permitAll()
                	.loginProcessingUrl("/login")
                )
        .logout(((logout) ->
 				logout
 					//.logoutUrl("/logout")
 					.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
 					.logoutSuccessUrl("/Accueil")
 					.invalidateHttpSession(true)
        		))		
                ;	
        // @formatter:on
		return http.build();
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
		//return new BCryptPasswordEncoder()
	}
}
