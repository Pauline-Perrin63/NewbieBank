package com.adaming.service;

import java.util.List;

import com.adaming.model.VirementBancaire;

public interface IVirementBancaireService {
		
		public VirementBancaire saveVirement (VirementBancaire v);
		public void deleteVirement (VirementBancaire v);
		public VirementBancaire updateVirement (VirementBancaire v);
		public VirementBancaire findByIdVirement (Integer id);
		public List<VirementBancaire> findAllVirement ();

		
	}

