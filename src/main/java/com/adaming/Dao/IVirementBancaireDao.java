package com.adaming.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adaming.model.VirementBancaire;

@Repository
public interface IVirementBancaireDao extends JpaRepository<VirementBancaire, Integer>{

}
