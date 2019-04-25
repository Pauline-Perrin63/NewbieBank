package com.adaming.service;

import java.util.List;

import com.adaming.model.Client;
import com.adaming.model.CompteBancaire;

public interface IClientService {

	public Client saveClient(Client c );
    public Client updateClient(Client c);
    public void deleteClient(Client c);
    public List<Client> getClient();
	
}
