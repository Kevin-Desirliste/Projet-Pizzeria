package fr.eni.projetPizza.bo;

public class Table {
	private int idTable;
	private String libelleTable;
	
	public Table(int idTable, String libelleTable) {
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

	public void add(Table table) {
		// TODO Auto-generated method stub
		
	}
		
}
