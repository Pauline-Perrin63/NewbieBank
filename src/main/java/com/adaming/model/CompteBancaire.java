package com.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CompteBancaire implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@OneToMany(mappedBy="compteBancaire")
	private int idCompte;
	private int codeCompte;
	private Date dateCreation;
	private double solde;
	private String codeClient;
	
	
	
	public CompteBancaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CompteBancaire(int idCompte, int codeCompte, Date dateCreation, double solde, String codeClient) {
		super();
		this.idCompte = idCompte;
		this.codeCompte = codeCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.codeClient = codeClient;
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
	public String getCodeClient() {
		return codeClient;
	}
	public void setCodeClient(String codeClient) {
		this.codeClient = codeClient;
	}
	@Override
	public String toString() {
		return "CompteBancaire [idCompte=" + idCompte + ", codeCompte=" + codeCompte + ", dateCreation=" + dateCreation
				+ ", solde=" + solde + ", codeClient=" + codeClient + "]";
	}
	
	
}
