package com.adaming.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adaming.model.Banque;

@Repository
public interface IbanqueDao extends JpaRepository<Banque, Integer>{

}
