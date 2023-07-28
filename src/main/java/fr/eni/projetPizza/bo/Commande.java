package fr.eni.projetPizza.bo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Commande {
	private int idCommande;
	private EtatCommande statutCommande;
	private LocalDateTime heureCommande;
	private int total;
	private int noTable;
	private List<LigneCommande> lignesCommande;
	
	public Commande() {
		super();
		this.lignesCommande = new ArrayList<>();
	}
	
	public Commande(int idCommande) {
		this();
		this.idCommande = idCommande;
	}

	public Commande( EtatCommande statutCommande, LocalDateTime heureCommande,  int noTable) {
		this();
		this.statutCommande = statutCommande;
		this.heureCommande = heureCommande;
		this.noTable = noTable;
	}

	
	public Commande(int idCommande, EtatCommande statutCommande, LocalDateTime heureCommande,  int noTable) {
		this();
		this.idCommande = idCommande;
		this.statutCommande = statutCommande;
		this.heureCommande = heureCommande;
		this.noTable = noTable;
	}

	public Commande(int idCommande, EtatCommande statutCommande, LocalDateTime heureCommande) {
		this();
		this.idCommande = idCommande;
		this.statutCommande = statutCommande;
		this.heureCommande = heureCommande;

	}
	
	public void ajouterLigneCommande(LigneCommande ligne) {
		this.lignesCommande.add(ligne);
	}

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public EtatCommande getStatutCommande() {
		return statutCommande;
	}

	public void setStatutCommande(EtatCommande statutCommande) {
		this.statutCommande = statutCommande;
	}

	public LocalDateTime getHeureCommande() {
		return heureCommande;
	}

	public void setHeureCommande(LocalDateTime heureCommande) {
		this.heureCommande = heureCommande;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getNoTable() {
		return noTable;
	}

	public void setNoTable(int noTable) {
		this.noTable = noTable;
	}

	public List<LigneCommande> getLignesCommande() {
		return lignesCommande;
	}
	
}

