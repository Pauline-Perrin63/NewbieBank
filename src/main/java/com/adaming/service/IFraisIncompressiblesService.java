package com.adaming.service;

import java.util.List;

import com.adaming.model.FraisIncompressibles;

public interface IFraisIncompressiblesService {
	
	public FraisIncompressibles saveFraisIncompressible (FraisIncompressibles fi);
	public void deleteFraisIncompressible (FraisIncompressibles fi);
	public FraisIncompressibles updateFraisIncompressible (FraisIncompressibles fi);
	public FraisIncompressibles findByIdFraisIncompressible (Integer id);
	public List<FraisIncompressibles> findAllFraisIncompressible ();
	
}
