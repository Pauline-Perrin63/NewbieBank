package com.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Banque implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBanque;
	private String nomBanque;
	private String adresseBanque;
	private String telBanque;
	@OneToMany
	List <CompteBancaire> compte;

	public Banque() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Banque(int idBanque, String nomBanque, String adresseBanque, String telBanque) {
		super();
		this.idBanque = idBanque;
		this.nomBanque = nomBanque;
		this.adresseBanque = adresseBanque;
		this.telBanque = telBanque;
	}
	public int getIdBanque() {
		return idBanque;
	}
	public void setIdBanque(int idBanque) {
		this.idBanque = idBanque;
	}
	public String getNomBanque() {
		return nomBanque;
	}
	public void setNomBanque(String nomBanque) {
		this.nomBanque = nomBanque;
	}
	public String getAdresseBanque() {
		return adresseBanque;
	}
	public void setAdresseBanque(String adresseBanque) {
		this.adresseBanque = adresseBanque;
	}
	public String getTelBanque() {
		return telBanque;
	}
	public void setTelBanque(String telBanque) {
		this.telBanque = telBanque;
	}
	
	public List<CompteBancaire> getCompte() {
		return compte;
	}
	public void setCompte(List<CompteBancaire> compte) {
		this.compte = compte;
	}
	@Override
	public String toString() {
		return "Banque [idBanque=" + idBanque + ", nomBanque=" + nomBanque + ", adresseBanque=" + adresseBanque
				+ ", telBanque=" + telBanque + "]";
	}
	
	
}
