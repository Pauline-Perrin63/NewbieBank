package com.adaming.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FraisIncompressibles implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdFraisIncompressibles;
	private String nomFrais;
	private Double montantFrais;
	@ManyToOne
	CompteBancaire compte;
	public FraisIncompressibles() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FraisIncompressibles(int idFraisIncompressibles, String nomFrais, Double montantFrais) {
		super();
		IdFraisIncompressibles = idFraisIncompressibles;
		this.nomFrais = nomFrais;
		this.montantFrais = montantFrais;
	}
	public int getIdFraisIncompressibles() {
		return IdFraisIncompressibles;
	}
	public void setIdFraisIncompressibles(int idFraisIncompressibles) {
		IdFraisIncompressibles = idFraisIncompressibles;
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
	@Override
	public String toString() {
		return "FraisIncompressibles [IdFraisIncompressibles=" + IdFraisIncompressibles + ", nomFrais=" + nomFrais
				+ ", montantFrais=" + montantFrais + "]";
	}
	
	
	
}
