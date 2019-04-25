package com.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adaming.Dao.ICompteBancaireDao;
import com.adaming.model.CompteBancaire;
import com.adaming.model.FraisIncompressibles;

public class CompteServiceImpl implements ICompteService {

	@Autowired
	ICompteBancaireDao iCompteBancaireDao;
	
	@Override
	public CompteBancaire saveCompteBancaire(CompteBancaire cb) {
		// TODO Auto-generated method stub
		return this.iCompteBancaireDao.save(cb);
	}

	@Override
	public CompteBancaire updateCompteBancaire(CompteBancaire cb) {
		// TODO Auto-generated method stub
		return this.iCompteBancaireDao.save(cb);
	}

	@Override
	public void deleteCompteBancaire(CompteBancaire cb) {
		// TODO Auto-generated method stub
		this.iCompteBancaireDao.delete(cb);
	}

	@Override
	public List<CompteBancaire> getCompteBancaire() {
		// TODO Auto-generated method stub
		return this.iCompteBancaireDao.findAll();
	}
	
	public CompteBancaire findByIdCompteBancaire(Integer id) {
		// TODO Auto-generated method stub
		return this.iCompteBancaireDao.findById(id).orElse(null);
	}

}
