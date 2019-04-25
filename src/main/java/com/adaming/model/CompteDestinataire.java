package com.adaming.model;

import java.util.Date;

import javax.persistence.ManyToOne;

public class CompteDestinataire extends CompteBancaire {

	@ManyToOne
	private int idCompteDestinataire;

	public CompteDestinataire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteDestinataire(int idCompte, int codeCompte, Date dateCreation, double solde, String codeClient) {
		super(idCompte, codeCompte, dateCreation, solde, codeClient);
		// TODO Auto-generated constructor stub
	}

	public int getIdCompteDestinataire() {
		return idCompteDestinataire;
	}

	public void setIdCompteDestinataire(int idCompteDestinataire) {
		this.idCompteDestinataire = idCompteDestinataire;
	}

	public CompteDestinataire(int idCompteDestinataire) {
		super();
		this.idCompteDestinataire = idCompteDestinataire;
	}

	@Override
	public String toString() {
		return "CompteDestinataire [idCompteDestinataire=" + idCompteDestinataire + "]";
	}
	
}
