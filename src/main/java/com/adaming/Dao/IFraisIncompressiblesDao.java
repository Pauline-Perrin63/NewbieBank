package com.adaming.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adaming.model.FraisIncompressibles;

@Repository
public interface IFraisIncompressiblesDao extends JpaRepository<FraisIncompressibles, Integer>{

}
