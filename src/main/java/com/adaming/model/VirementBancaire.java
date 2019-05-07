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
public class VirementBancaire implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVirement;
	private double montantVirement;
	private String destinataire;
	private int idDestinataire;
	private String emetteur;
	private int idEmetteur;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_compte_emetteur")
	CompteBancaire virementEmis;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_compte_receveur")
	CompteBancaire virementRecu;


	public VirementBancaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VirementBancaire(int idVirement, double montantVirement, String destinataire, int idDestinataire,
			String emetteur, int idEmetteur, CompteBancaire virementEmis, CompteBancaire virementRecu) {

		super();
		this.idVirement = idVirement;
		this.montantVirement = montantVirement;
		this.destinataire = destinataire;
		this.idDestinataire = idDestinataire;
		this.emetteur = emetteur;
		this.idEmetteur = idEmetteur;
		this.virementEmis = virementEmis;
		this.virementRecu = virementRecu;

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

	public String getEmetteur() {
		return emetteur;
	}

	public void setEmetteur(String emetteur) {
		this.emetteur = emetteur;
	}

	public int getIdEmetteur() {
		return idEmetteur;
	}

	public void setIdEmetteur(int idEmetteur) {
		this.idEmetteur = idEmetteur;
	}

	public CompteBancaire getVirementEmis() {
		return virementEmis;
	}

	public void setVirementEmis(CompteBancaire virementEmis) {
		this.virementEmis = virementEmis;
	}

	public CompteBancaire getVirementRecu() {
		return virementRecu;
	}

	public void setVirementRecu(CompteBancaire virementRecu) {
		this.virementRecu = virementRecu;
	}



	@Override
	public String toString() {
		return "VirementBancaire [idVirement=" + idVirement + ", montantVirement=" + montantVirement + ", destinataire="
				+ destinataire + ", idDestinataire=" + idDestinataire + ", emetteur=" + emetteur + ", idEmetteur="
				+ idEmetteur + ", virementEmis=" + virementEmis + ", virementRecu=" + virementRecu + "]";
	}



}

