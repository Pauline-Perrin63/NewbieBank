package com.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.adaming.Dao.ICompteBancaireDao;
import com.adaming.model.CompteBancaire;

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
		return iCBDao.save(cb);
	}
}
