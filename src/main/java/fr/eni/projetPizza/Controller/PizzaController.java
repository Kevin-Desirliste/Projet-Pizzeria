package fr.eni.projetPizza.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.projetPizza.bo.Table;
import fr.eni.projetPizza.dal.ArticleDAO;

@Controller
public class PizzaController {
	  @Autowired
	    private ArticleDAO articleDAO; // Injection du DAO pour accéder aux données de la table "Table"

    @GetMapping("/Accueil")
    public String afficherAccueil() {
        return "Accueil"; // renvoie à un fichier de vue nommé "Accueil.html" 
    }

    @GetMapping("/Table")
    public String afficherTable() {
        return "Table"; // renvoie à un fichier de vue nommé "Table.html"
    }
    
//    @GetMapping("/Table")
//    public String afficherTable(Model model) {
//        try 
//        {
//            List<Table> tables = articleDAO.selectTable();  // Récupérer les données de la table "Table" depuis la base de données
//            model.addAttribute("tables", tables);  // Ajouter les données à un modèle (Model) pour les transmettre à la vue (HTML)
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "Table";         // Renvoyer le nom de la vue "Table.html" pour l'affichage
//    }
	
	@GetMapping("/Connexion")
    public String afficherConnexion() {
        // Votre logique pour afficher la page "Connexion.html"
        return "Connexion"; // renvoie à un fichier de vue nommé "Connexion.html"
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