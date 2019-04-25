package com.adaming.service;

import java.util.List;

import com.adaming.model.Banque;
import com.adaming.model.CompteBancaire;

public interface ICompteService {

	public CompteBancaire saveCompteBancaire(CompteBancaire cb);
	public CompteBancaire updateCompteBancaire(CompteBancaire cb);
	public void deleteCompteBancaire(CompteBancaire cb);
	public List<CompteBancaire> getCompteBancaire();
}
