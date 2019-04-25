package com.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adaming.Dao.IVirementBancaireDao;
import com.adaming.model.VirementBancaire;

public class VirementBancaireServiceImpl implements IVirementBancaireService {

	@Autowired
	IVirementBancaireDao iVirementBancaireDao;
	
	public VirementBancaire saveVirement(VirementBancaire v) {
		// TODO Auto-generated method stub
		return this.iVirementBancaireDao.save(v);
	}

	public void deleteVirement(VirementBancaire v) {
		// TODO Auto-generated method stub
		 this.iVirementBancaireDao.delete(v);
	}

	public VirementBancaire updateVirement(VirementBancaire v) {
		// TODO Auto-generated method stub
		return this.iVirementBancaireDao.save(v);
	}

	public VirementBancaire findByIdVirement(Integer id) {
		// TODO Auto-generated method stub
		return this.iVirementBancaireDao.findById(id).orElse(null);
	}

	public List<VirementBancaire> findAllVirement() {
		// TODO Auto-generated method stub
		return this.iVirementBancaireDao.findAll();
	}

}
