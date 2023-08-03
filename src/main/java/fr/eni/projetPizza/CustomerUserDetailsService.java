package fr.eni.projetPizza;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomerUserDetailsService implements UserDetailsService{
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("pizzaiollo".equals(username)) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("PIZZAIOLLO"));
            return new User("pizzaiollo", "pizzaiollo", authorities);
        } else if ("serveur".equals(username)) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("SERVEUR"));
            return new User("serveur", "serveur", authorities);
        } else {
            throw new UsernameNotFoundException("Utilisateur non trouvé !");
        }
	}
}
