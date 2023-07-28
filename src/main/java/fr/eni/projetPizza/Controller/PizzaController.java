package fr.eni.projetPizza.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.demoCouches.bo.User;
import fr.eni.projetPizza.bll.ArticleManager;
import fr.eni.projetPizza.bo.Article;
import fr.eni.projetPizza.bo.Commande;
import fr.eni.projetPizza.dal.ArticleDAO;

@Controller
public class PizzaController {
	
	private ArticleDAO articleDAO; // Injection du DAO pour accéder aux données de la table "Table"
	private ArticleManager articleManager;
	
	@Autowired
	public PizzaController(ArticleDAO articleDAO, ArticleManager articleManager) {
		this.articleDAO = articleDAO;
		this.articleManager = articleManager;
	}
	  

    @GetMapping("/Accueil")
    public String afficherAccueil() {
        return "Accueil"; // renvoie à un fichier de vue nommé "Accueil.html" 
    }

    @GetMapping("/test")
    public String test()
    {
    	return "test";
    }

    @PostMapping("/test")
    public String traitementPosttest(@RequestParam int[] idProduits)
    {
    	System.out.println("idProduits: " + idProduits);
    	for(int i: idProduits) {
    		System.out.println();
    	}
    	return "test";
    }

    
    @GetMapping("/articles")
    public String afficherArticles(Model model) {
        try 
        {
//            List<Article> articles = articleManager.selectArticles();  // Récupérer les données de la table "Table" depuis la base de données
//            model.addAttribute("articles", articles);  // Ajouter les données à un modèle (Model) pour les transmettre à la vue (HTML)
            List<Article> entree = articleManager.selectEntree(); 
            model.addAttribute("entrees", entree);
            
            List<Article> plat = articleManager.selectPlat(); 
            model.addAttribute("plats", plat);
            
            List<Article> dessert = articleManager.selectDessert(); 
            model.addAttribute("desserts", dessert);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "articles"; 
    }
    
//    @PostMapping("/articles")
//    public String traitementPostArticles(@RequestParam int[] quantite)
//    {
//    	//System.out.println("quantite: " + Arrays.toString(quantite));
//    	for(int i: quantite) {
//    		System.out.println(i);
//    	}
//    	return "articles";
//    }
    @PostMapping("/articles")
    public String traitementPostArticles(Commande commande) {
    	this.articleManager.InsertCommande(commande);
		return "articles";
    }
	
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