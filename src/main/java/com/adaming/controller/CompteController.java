package com.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@PostMapping(value = "/ajouterCompte", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CompteBancaire addNewCompte(@RequestBody CompteBancaire Compte) {
		return this.compteService.saveCompteBancaire(Compte);

	}

	@PutMapping("/{id}")
	public CompteBancaire updateCompte(@RequestBody CompteBancaire Compte, @PathVariable int id) {
		if (compteService.findByIdCompteBancaire(id) == null) {
			return null;
		} else {
			return compteService.saveCompteBancaire(Compte);
		}
	}

	@DeleteMapping("/{id}")
	public void deleteCompte(@PathVariable int id) {
		if (compteService.findByIdCompteBancaire(id) != null) {
			compteService.deleteCompteBancaire(compteService.findByIdCompteBancaire(id));
		}
	}

	@GetMapping(value = "/findByIdCompte/{id}")
	public CompteBancaire getById(@PathVariable int id) {
		if (compteService.findByIdCompteBancaire(id) == null) {
			return null;
		} else {
			return compteService.findByIdCompteBancaire(id);
		}
	}

	@GetMapping(value = "/Comptes")
	public List<CompteBancaire> findAllCompte() {
		List<CompteBancaire> Comptes = compteService.findAllCompteBancaire();
		return Comptes;
	}

}
