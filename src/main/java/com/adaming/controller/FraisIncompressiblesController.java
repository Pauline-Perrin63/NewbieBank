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

import com.adaming.model.FraisIncompressibles;
import com.adaming.service.FraisIncompressiblesServiceImpl;
import com.adaming.service.IFraisIncompressiblesService;



@RestController
@CrossOrigin
@RequestMapping("/fraisincompressibles")
public class FraisIncompressiblesController {

	@Autowired
	IFraisIncompressiblesService fraisIncompressiblesService;

	public FraisIncompressiblesController(FraisIncompressiblesServiceImpl fraisIncompressiblesServiceImpl) {
		this.fraisIncompressiblesService = fraisIncompressiblesServiceImpl;
	}

	@RequestMapping(value = "/ajouterFraisIncompressibles", method = RequestMethod.POST)
	public ResponseEntity<FraisIncompressibles> createFraisIncompressibles(@RequestBody FraisIncompressibles fraisIncompressibles) {
		fraisIncompressibles = this.fraisIncompressiblesService.saveFraisIncompressible(fraisIncompressibles);
		return new ResponseEntity<FraisIncompressibles>(fraisIncompressibles, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/modifierFraisIncompressibles", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FraisIncompressibles> updateFraisIncompressibles(@RequestBody FraisIncompressibles FraisIncompressibles) {
		FraisIncompressibles = this.fraisIncompressiblesService.updateFraisIncompressible(FraisIncompressibles);
		return new ResponseEntity<FraisIncompressibles>(FraisIncompressibles, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/supprimerFraisIncompressibles", method = RequestMethod.DELETE)
	public ResponseEntity<FraisIncompressibles> deleteFraisIncompressibles(@RequestBody FraisIncompressibles fraisIncompressibles) {
		this.fraisIncompressiblesService.deleteFraisIncompressible(fraisIncompressibles);
		return new ResponseEntity<FraisIncompressibles>(fraisIncompressibles, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getFraisIncompressiblesById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FraisIncompressibles> getFraisIncompressiblesById(@RequestBody Integer id) {
		FraisIncompressibles FraisIncompressibles = this.fraisIncompressiblesService.findByIdFraisIncompressible(id);
		return new ResponseEntity<FraisIncompressibles>(FraisIncompressibles, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/FraisIncompressibless", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FraisIncompressibles>> getAllFraisIncompressibless() {
		List<FraisIncompressibles> FraisIncompressibless = this.fraisIncompressiblesService.findAllFraisIncompressible();
		return new ResponseEntity<List<FraisIncompressibles>>(FraisIncompressibless, HttpStatus.OK);
	}

}


