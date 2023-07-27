package fr.eni.projetPizza.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PizzaController {
	
	@GetMapping("/Connexion")
    public String afficherConnexion() {
        // Votre logique pour afficher la page "Connexion.html"
        return "Connexion"; // renvoie à un fichier de vue nommé "Connexion.html"
    }
	
    @GetMapping("/Accueil")
    public String afficherAcceuil() {
        return "Accueil"; 
    }

    @GetMapping("/Carte")
    public String afficherCarte() {
        return "Carte";
    }
    
    @GetMapping("/Plats")
    public String afficherPlats() {
        return "Plats";
    }
    
    @GetMapping("/Panier")
    public String afficherPanier() {
        return "Panier";
    }
    
    @GetMapping("/Commande")
    public String afficherCommande() {
        return "Commande";
    }
    
    @GetMapping("/Table")
    public String afficherTable() {
        return "Table";
    }
    
    @GetMapping("/TableDetail")
    public String afficherTableDetail() {
        return "TableDetail";
    }
    
    @GetMapping("/Historique")
    public String afficherHistorique() {
        return "Historique";
    }
    
    @GetMapping("/Preparation")
    public String afficherPreparation() {
        return "Preparation";
    }
}