package com.adaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class CompteBancaire implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCompte;
	private int codeCompte;
	private Date dateCreation;
	private double solde;
	private double decouvert;
	private double plafond;
	private String codeClient;
	@ManyToOne
	private Client client;
	@ManyToOne
	private Banque banque;
	@OneToMany
	List<FraisIncompressibles> frais;
	@OneToMany
	List<VirementBancaire> viremis;
	@OneToMany
	List<VirementBancaire> virrecu;
	
	
	public CompteBancaire() {
		super();
		// TODO Auto-generated constructor stub
	}



	public CompteBancaire(int idCompte, int codeCompte, Date dateCreation, double solde, double decouvert,
			double plafond) {
		super();
		this.idCompte = idCompte;
		this.codeCompte = codeCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.decouvert = decouvert;
		this.plafond = plafond;
	}



	@Override
	public String toString() {
		return "CompteBancaire [idCompte=" + idCompte + ", codeCompte=" + codeCompte + ", dateCreation=" + dateCreation
				+ ", solde=" + solde + ", decouvert=" + decouvert + ", plafond=" + plafond + ", codeClient="
				+ codeClient + ", client=" + client + ", banque=" + banque + ", frais=" + frais + ", viremis=" + viremis
				+ ", virrecu=" + virrecu + "]";
	}



	public int getIdCompte() {
		return idCompte;
	}



	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}



	public int getCodeCompte() {
		return codeCompte;
	}



	public void setCodeCompte(int codeCompte) {
		this.codeCompte = codeCompte;
	}



	public Date getDateCreation() {
		return dateCreation;
	}



	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}



	public double getSolde() {
		return solde;
	}



	public void setSolde(double solde) {
		this.solde = solde;
	}



	public double getDecouvert() {
		return decouvert;
	}



	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}



	public double getPlafond() {
		return plafond;
	}



	public void setPlafond(double plafond) {
		this.plafond = plafond;
	}



	public String getCodeClient() {
		return codeClient;
	}



	public void setCodeClient(String codeClient) {
		this.codeClient = codeClient;
	}



	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
	}



	public Banque getBanque() {
		return banque;
	}



	public void setBanque(Banque banque) {
		this.banque = banque;
	}



	public List<FraisIncompressibles> getFrais() {
		return frais;
	}



	public void setFrais(List<FraisIncompressibles> frais) {
		this.frais = frais;
	}



	public List<VirementBancaire> getViremis() {
		return viremis;
	}



	public void setViremis(List<VirementBancaire> viremis) {
		this.viremis = viremis;
	}



	public List<VirementBancaire> getVirrecu() {
		return virrecu;
	}



	public void setVirrecu(List<VirementBancaire> virrecu) {
		this.virrecu = virrecu;
	}



	public double montantDecouvert() {
		if (solde<0) {
			return solde;
		}
		else {
			return solde;
		}
	}
	
	public double Plafondautorise() {
		if (solde>100000) {
			return solde;
		}
		else {
			return solde;
		}
	}
}
