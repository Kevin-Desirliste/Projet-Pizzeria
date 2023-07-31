package fr.eni.projetPizza.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.projetPizza.bll.ArticleManager;
import fr.eni.projetPizza.bo.Article;
import fr.eni.projetPizza.bo.Commande;
import fr.eni.projetPizza.bo.EtatCommande;
import fr.eni.projetPizza.bo.LigneCommande;
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

    @PostMapping("/articles")
    public String traitementPostArticles(@RequestParam int[] quantite, @RequestParam int NoTable, @RequestParam int[] idArticle, Commande commande) {

        int totalCommande = 0;

        for (int i = 0; i < quantite.length; i++) {
            if (quantite[i] > 0) {
                Article article = this.articleManager.getArticleById(idArticle[i]);
                totalCommande += article.getPrix() * quantite[i];
                
                LigneCommande ligneCommande = new LigneCommande();
                ligneCommande.setArticle(article);
                ligneCommande.setQuantite(quantite[i]);

                commande.ajouterLigneCommande(ligneCommande);
            }
        }

        commande.setNoTable(NoTable);
        EtatCommande statutCommande = new EtatCommande();
        statutCommande.setId_etat_commande(1);
        commande.setStatutCommande(statutCommande);
        commande.setTotal(totalCommande);

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
    
    @GetMapping("/Historique")
    public String afficherHistorique() {
        return "Historique";
    }
    
    @GetMapping("/Preparation")
    public String afficherPreparation() {
        return "Preparation";
    }
}