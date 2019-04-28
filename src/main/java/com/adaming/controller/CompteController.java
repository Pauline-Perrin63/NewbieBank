package com.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.model.CompteBancaire;
import com.adaming.service.CompteServiceImpl;
import com.adaming.service.ICompteService;

@RestController
@CrossOrigin
@RequestMapping("/compte")
public class CompteController {


			@Autowired
			ICompteService compteService;

			public CompteController(CompteServiceImpl compteServiceImpl) {
				this.compteService = compteServiceImpl;
			}

			@RequestMapping(value = "/ajouterCompte", method = RequestMethod.POST)
			public ResponseEntity<CompteBancaire> createCompte(@RequestBody CompteBancaire compte) {
				compte = this.compteService.saveCompteBancaire(compte);
				return new ResponseEntity<CompteBancaire>(compte, HttpStatus.OK);
			}
			
			@RequestMapping(value = "/modifierCompte", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<CompteBancaire> updateCompte(@RequestBody CompteBancaire Compte) {
				Compte = this.compteService.updateCompteBancaire(Compte);
				return new ResponseEntity<CompteBancaire>(Compte, HttpStatus.OK);
			}
			
			@RequestMapping(value = "/supprimerCompte", method = RequestMethod.DELETE)
			public ResponseEntity<CompteBancaire> deleteCompte(@RequestBody CompteBancaire compte) {
				this.compteService.deleteCompteBancaire(compte);
				return new ResponseEntity<CompteBancaire>(compte, HttpStatus.OK);
			}
			
			@RequestMapping(value = "/getCompteById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<CompteBancaire> getCompteById(@RequestBody Integer id) {
				CompteBancaire Compte = this.compteService.findByIdCompteBancaire(id);
				return new ResponseEntity<CompteBancaire>(Compte, HttpStatus.OK);
			}
			
			@RequestMapping(value = "/Comptes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<List<CompteBancaire>> getAllComptes() {
				List<CompteBancaire> Comptes = this.compteService.findAllCompteBancaire();
				return new ResponseEntity<List<CompteBancaire>>(Comptes, HttpStatus.OK);
			}
		
}
