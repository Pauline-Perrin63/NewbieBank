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

import com.adaming.model.VirementBancaire;
import com.adaming.service.IVirementBancaireService;
import com.adaming.service.VirementBancaireServiceImpl;



@RestController
@CrossOrigin
@RequestMapping("/virement")
public class VirementController {

	@Autowired
	IVirementBancaireService virementService;

	public VirementController(VirementBancaireServiceImpl virementServiceImpl) {
		this.virementService = virementServiceImpl;
	}

	@RequestMapping(value = "/ajouterVirement", method = RequestMethod.POST)
	public ResponseEntity<VirementBancaire> createVirement(@RequestBody VirementBancaire virement) {
		virement = this.virementService.saveVirement(virement);
		return new ResponseEntity<VirementBancaire>(virement, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/modifierVirement", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VirementBancaire> updateVirement(@RequestBody VirementBancaire Virement) {
		Virement = this.virementService.updateVirement(Virement);
		return new ResponseEntity<VirementBancaire>(Virement, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/supprimerVirement", method = RequestMethod.DELETE)
	public ResponseEntity<VirementBancaire> deleteVirement(@RequestBody VirementBancaire virement) {
		this.virementService.deleteVirement(virement);
		return new ResponseEntity<VirementBancaire>(virement, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getVirementById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VirementBancaire> getVirementById(@RequestBody Integer id) {
		VirementBancaire Virement = this.virementService.findByIdVirement(id);
		return new ResponseEntity<VirementBancaire>(Virement, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/Virements", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<VirementBancaire>> getAllVirements() {
		List<VirementBancaire> Virements = this.virementService.findAllVirement();
		return new ResponseEntity<List<VirementBancaire>>(Virements, HttpStatus.OK);
	}

}

