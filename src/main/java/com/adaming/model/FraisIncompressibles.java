package com.adaming.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class FraisIncompressibles implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFraisIncompressibles;
	private String nomFrais;
	private Double montantFrais;
	@ManyToOne
	@JoinColumn(name = "id_compte")
	private CompteBancaire compte;

	public FraisIncompressibles() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	public FraisIncompressibles(int idFraisIncompressibles, String nomFrais, Double montantFrais,
			CompteBancaire compte) {
		super();
		this.idFraisIncompressibles = idFraisIncompressibles;
		this.nomFrais = nomFrais;
		this.montantFrais = montantFrais;
		this.compte = compte;
	}



	public int getIdFraisIncompressibles() {
		return idFraisIncompressibles;
	}
	public void setIdFraisIncompressibles(int idFraisIncompressibles) {
		this.idFraisIncompressibles = idFraisIncompressibles;
	}
	public String getNomFrais() {
		return nomFrais;
	}
	public void setNomFrais(String nomFrais) {
		this.nomFrais = nomFrais;
	}
	public Double getMontantFrais() {
		return montantFrais;
	}
	public void setMontantFrais(Double montantFrais) {
		this.montantFrais = montantFrais;
	}
	
	
	public CompteBancaire getCompte() {
		return compte;
	}



	public void setCompte(CompteBancaire compte) {
		this.compte = compte;
	}



	@Override
	public String toString() {
		return "FraisIncompressibles [idFraisIncompressibles=" + idFraisIncompressibles + ", nomFrais=" + nomFrais
				+ ", montantFrais=" + montantFrais + ", compte=" + compte + "]";
	}



	



	
	
	
	
}
