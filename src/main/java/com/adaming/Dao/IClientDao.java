package com.adaming.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adaming.model.Client;


public interface IClientDao extends JpaRepository<Client, Integer> {
	
	public Client findById (int id);
	
}
