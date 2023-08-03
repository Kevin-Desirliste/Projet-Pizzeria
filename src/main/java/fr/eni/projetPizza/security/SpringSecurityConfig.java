package fr.eni.projetPizza.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// @formatter:off
        http.authorizeHttpRequests((authorize) -> authorize
        		.requestMatchers("/Accueil", "/Carte", "/Panier", "/*.css", "/images/**").permitAll()
                .requestMatchers("/Commande", "/articles").hasAuthority("SERVEUR")
        		.requestMatchers("/Preparation").hasAuthority("PIZZAIOLLO")
                .anyRequest().authenticated()               
                )
        .formLogin(Customizer.withDefaults())      
//                .formLogin((formLogin) -> formLogin
//                	.loginPage("/Login")
//                	.permitAll()
//                	.defaultSuccessUrl("/articles")
//                )
        .logout(((logout) ->
 				logout.invalidateHttpSession(true)
 					.logoutSuccessUrl("/Accueil")  
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
