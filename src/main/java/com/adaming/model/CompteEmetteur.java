package com.adaming.model;

import java.util.Date;

import javax.persistence.ManyToOne;

public class CompteEmetteur extends CompteBancaire {

	@ManyToOne
	private int idCompteEmetteur;

	public CompteEmetteur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteEmetteur(int idCompte, int codeCompte, Date dateCreation, double solde, String codeClient) {
		super(idCompte, codeCompte, dateCreation, solde, codeClient);
		// TODO Auto-generated constructor stub
	}

	public int getIdCompteEmetteur() {
		return idCompteEmetteur;
	}

	public void setIdCompteEmetteur(int idCompteEmetteur) {
		this.idCompteEmetteur = idCompteEmetteur;
	}

	public CompteEmetteur(int idCompteEmetteur) {
		super();
		this.idCompteEmetteur = idCompteEmetteur;
	}

	@Override
	public String toString() {
		return "CompteEmetteur [idCompteEmetteur=" + idCompteEmetteur + "]";
	}
	
}
