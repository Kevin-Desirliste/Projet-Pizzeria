package fr.eni.projetPizza.dal;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.eni.projetPizza.bo.Serveur;

public class ServeurJdbcImpl {

//	private JdbcTemplate jdbcTemplate;
//
//	Object serveur = jdbcTemplate.queryForObject( "select id_utilisateur, nom_utilisateur from t_actor where id = 2", (resultSet, rowNum) -> 
//	{ 
//		Object newServeur = new Serveur(); 
//		newServeur.setIdServeur(resultSet.getString("first_name")); 
//		newServeur.setLibelle(resultSet.getString("last_name")); 
//		return newServeur; 
//	}, 1212L);
//	
//	Object pizzaiollo = jdbcTemplate.queryForObject( "select first_name, last_name from utilisateur where id = 1", (resultSet, rowNum) -> 
//	{ 
//		Object newServeur = new Serveur(); 
//		newServeur.setIdServeur(resultSet.getString("first_name")); 
//		newServeur.setLibelle(resultSet.getString("last_name")); 
//		return newServeur; 
//	}, 1212L);
}
