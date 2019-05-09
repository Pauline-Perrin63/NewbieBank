package com.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.Dao.IFraisIncompressiblesDao;
import com.adaming.model.FraisIncompressibles;
@Service
public class FraisIncompressiblesServiceImpl implements IFraisIncompressiblesService {
	
	@Autowired
	IFraisIncompressiblesDao iFraisIncompressiblesDao;
	
	public FraisIncompressiblesServiceImpl(IFraisIncompressiblesDao iFraisIncompressiblesDao) {
		// TODO Auto-generated constructor stub
		this.iFraisIncompressiblesDao = iFraisIncompressiblesDao;
	}

	public FraisIncompressibles saveFraisIncompressible(FraisIncompressibles fi) {
		// TODO Auto-generated method stub
		return iFraisIncompressiblesDao.save(fi);
	}

	public void deleteFraisIncompressible(FraisIncompressibles fi) {
		// TODO Auto-generated method stub
		iFraisIncompressiblesDao.delete(fi);
	}

	public FraisIncompressibles updateFraisIncompressible(FraisIncompressibles fi) {
		// TODO Auto-generated method stub
		return iFraisIncompressiblesDao.save(fi);
	}


	public List<FraisIncompressibles> findAllFraisIncompressible() {
		// TODO Auto-generated method stub
		return iFraisIncompressiblesDao.findAll();
	}

	public FraisIncompressibles findByIdFraisIncompressible(Integer id) {
		// TODO Auto-generated method stub
		return iFraisIncompressiblesDao.findById(id).orElse(null);
	}

	
	

}
