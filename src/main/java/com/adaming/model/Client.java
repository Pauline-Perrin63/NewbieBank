package com.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idClient;
	private String nomClient;
	private String prenomClient;
	private String adresseClient;
	private int age;
	private Date dateEnregistrement;
	private String sexe;
	private String telClient;
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(int idClient, String nomClient, String prenomClient, String adresseClient, int age,
			Date dateEnregistrement, String sexe, String telClient) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.adresseClient = adresseClient;
		this.age = age;
		this.dateEnregistrement = dateEnregistrement;
		this.sexe = sexe;
		this.telClient = telClient;
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getPrenomClient() {
		return prenomClient;
	}
	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}
	public String getAdresseClient() {
		return adresseClient;
	}
	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDateEnregistrement() {
		return dateEnregistrement;
	}
	public void setDateEnregistrement(Date dateEnregistrement) {
		this.dateEnregistrement = dateEnregistrement;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getTelClient() {
		return telClient;
	}
	public void setTelClient(String telClient) {
		this.telClient = telClient;
	}
	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nomClient=" + nomClient + ", prenomClient=" + prenomClient
				+ ", adresseClient=" + adresseClient + ", age=" + age + ", dateEnregistrement=" + dateEnregistrement
				+ ", sexe=" + sexe + ", telClient=" + telClient + "]";
	}
	
	
}