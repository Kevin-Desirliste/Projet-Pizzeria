package fr.eni.projetPizza.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PizzaController {
    @GetMapping("/Acceuil")
    public String afficherAcceuil() {
        // Votre logique pour afficher les pizzas
        return "Acceuil"; // renvoie à un fichier de vue nommé "Acceuil.html" par exemple
    }

    @GetMapping("/Table")
    public String afficherTable() {
        // Votre logique pour afficher la page "Table.html"
        return "Table"; // renvoie à un fichier de vue nommé "Table.html"
    }
}