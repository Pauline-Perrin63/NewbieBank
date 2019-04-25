package com.adaming.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VirementBancaire implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idVirement;
	private double montantVirement;
	private String destinataire;
	private int idDestinataire;
	private CompteBancaire compteDest;
	private CompteBancaire comptEmet;
	public VirementBancaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VirementBancaire(int idVirement, double montantVirement, String destinataire, int idDestinataire) {
		super();
		this.idVirement = idVirement;
		this.montantVirement = montantVirement;
		this.destinataire = destinataire;
		this.idDestinataire = idDestinataire;
	}
	public int getIdVirement() {
		return idVirement;
	}
	public void setIdVirement(int idVirement) {
		this.idVirement = idVirement;
	}
	public double getMontantVirement() {
		return montantVirement;
	}
	public void setMontantVirement(double montantVirement) {
		this.montantVirement = montantVirement;
	}
	public String getDestinataire() {
		return destinataire;
	}
	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}
	public int getIdDestinataire() {
		return idDestinataire;
	}
	public void setIdDestinataire(int idDestinataire) {
		this.idDestinataire = idDestinataire;
	}
	@Override
	public String toString() {
		return "VirementBancaire [idVirement=" + idVirement + ", montantVirement=" + montantVirement + ", destinataire="
				+ destinataire + ", idDestinataire=" + idDestinataire + "]";
	}
	
	

}