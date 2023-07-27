package fr.eni.projetPizza.bo;

public class EtatCommande {
	private int idTable;
	private String libelleTable;
	
	public EtatCommande(int idTable, String libelleTable) {
		super();
		this.idTable = idTable;
		this.libelleTable = libelleTable;
	}

	public int getIdTable() {
		return idTable;
	}

	public void setIdTable(int idTable) {
		this.idTable = idTable;
	}

	public String getLibelleTable() {
		return libelleTable;
	}

	public void setLibelleTable(String libelleTable) {
		this.libelleTable = libelleTable;
	}

	public void add(EtatCommande table) {
		// TODO Auto-generated method stub
		
	}
		
}
