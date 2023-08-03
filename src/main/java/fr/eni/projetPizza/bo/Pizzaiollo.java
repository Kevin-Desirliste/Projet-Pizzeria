package fr.eni.projetPizza.bo;

public class Pizzaiollo {

	private int idPizzaiollo;
	private String libelle;
	
	public Pizzaiollo() {
		
	}
	
	public Pizzaiollo(int idPizzaiollo, String libelle) {
		super();
		this.idPizzaiollo = idPizzaiollo;
		this.libelle = libelle;
	}

	public int getIdPizzaiollo() {
		return idPizzaiollo;
	}

	public void setIdPizzaiollo(int idPizzaiollo) {
		this.idPizzaiollo = idPizzaiollo;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
}
