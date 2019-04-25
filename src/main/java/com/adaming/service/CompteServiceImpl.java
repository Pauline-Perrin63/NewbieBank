package com.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adaming.Dao.IClientDao;
import com.adaming.Dao.ICompteBancaireDao;
import com.adaming.model.CompteBancaire;
import com.adaming.model.FraisIncompressibles;

public class CompteServiceImpl implements ICompteService {

	@Autowired
	ICompteBancaireDao iCBDao;

	public CompteServiceImpl(ICompteBancaireDao iCBDao) {
		// TODO Auto-generated constructor stub
		this.iCBDao = iCBDao;
		
	}
	
	@Override
	public CompteBancaire saveCompteBancaire(CompteBancaire cb) {
		// TODO Auto-generated method stub
		return null;
	}
}
