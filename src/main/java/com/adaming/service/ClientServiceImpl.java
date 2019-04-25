package com.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.Dao.IClientDao;
import com.adaming.model.Client;
import com.adaming.model.CompteBancaire;
import com.adaming.model.FraisIncompressibles;
import com.adaming.model.VirementBancaire;

@Service
public class ClientServiceImpl implements IClientService{
	

	@Autowired
	IClientDao iClientDao;


	public ClientServiceImpl(IClientDao clientDao) {
		// TODO Auto-generated constructor stub
		this.iClientDao = clientDao;
		
	}

	public Client saveClient(Client c) {
		// TODO Auto-generated method stub
		return  iClientDao.save(c);
	}

	public Client updateClient(Client c) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteClient(Client c) {
		// TODO Auto-generated method stub
		
	}

	public List<Client> getClient() {
		// TODO Auto-generated method stub
		return null;
	}



	
}


