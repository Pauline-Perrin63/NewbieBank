package com.adaming.service;

import java.util.List;

import com.adaming.model.Client;
import com.adaming.model.CompteBancaire;
import com.adaming.model.FraisIncompressibles;

public interface IClientService {

	public Client saveClient(Client c );
    public Client updateClient(Client c);
    public void deleteClient(Client c);
    public Client findByIdClient (Integer id);
	public List<Client> findAllClient ();
}
