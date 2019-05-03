package com.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@PostMapping(value = "/ajouterVirement", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public VirementBancaire saveVirement(@RequestBody VirementBancaire virementBancaire) {
		return this.virementService.saveVirement(virementBancaire);
	}

	@PutMapping("/{id}")
	public VirementBancaire updateVirement (@RequestBody VirementBancaire virementBancaire, @PathVariable int id) {
		if(virementService.updateVirement(virementBancaire)== null) {
			return null;
		} else {
			return virementService.updateVirement(virementBancaire);
		}
	}

	@DeleteMapping("/{id}")
	public void deleteVirement(@PathVariable int id) {
		if(virementService.findByIdVirement(id)!= null) {
			virementService.deleteVirement(virementService.findByIdVirement(id));
		}
	} 

	@GetMapping(value = "/findById/{id}")
	public VirementBancaire getVirementById(@PathVariable int id) {
		if(virementService.findByIdVirement(id)== null) {
			return null;
		} else {
			return virementService.findByIdVirement(id);
		}
	}

	@GetMapping(value = "/all")
	public List<VirementBancaire> getAllVirement() {
		List<VirementBancaire> vb = virementService.findAllVirement();
	return vb;
	}

}

