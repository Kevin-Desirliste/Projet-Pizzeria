package fr.eni.projetPizza.bo;

public class Role {
	private int idRole;
	private String libelleRole;
	
	public Role(int idRole, String libelleRole) {
		super();
		this.idRole = idRole;
		this.libelleRole = libelleRole;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getLibelleRole() {
		return libelleRole;
	}

	public void setLibelleRole(String libelleRole) {
		this.libelleRole = libelleRole;
	}
	
}
