package com.adaming.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adaming.model.CompteBancaire;

@Repository
public interface ICompteBancaireDao extends JpaRepository<CompteBancaire, Integer>{

}
