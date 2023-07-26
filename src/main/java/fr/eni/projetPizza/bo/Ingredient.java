package fr.eni.projetPizza.bo;

public class Ingredient {
	private int idIngredient;
	private String nomIngredient;
	private int quantiteIngredient;
	
	public Ingredient(int idIngredient, String nomIngredient, int quantiteIngredient) {
		super();
		this.idIngredient = idIngredient;
		this.nomIngredient = nomIngredient;
		this.quantiteIngredient = quantiteIngredient;
	}

	public int getIdIngredient() {
		return idIngredient;
	}

	public void setIdIngredient(int idIngredient) {
		this.idIngredient = idIngredient;
	}

	public String getNomIngredient() {
		return nomIngredient;
	}

	public void setNomIngredient(String nomIngredient) {
		this.nomIngredient = nomIngredient;
	}

	public int getQuantiteIngredient() {
		return quantiteIngredient;
	}

	public void setQuantiteIngredient(int quantiteIngredient) {
		this.quantiteIngredient = quantiteIngredient;
	}
	
}
