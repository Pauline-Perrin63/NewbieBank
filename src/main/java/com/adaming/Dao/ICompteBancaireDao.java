package com.adaming.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adaming.model.CompteBancaire;

public interface ICompteBancaireDao extends JpaRepository<CompteBancaire, Integer>{

}
