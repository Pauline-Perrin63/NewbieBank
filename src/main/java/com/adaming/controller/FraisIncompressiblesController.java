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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.model.FraisIncompressibles;
import com.adaming.service.FraisIncompressiblesServiceImpl;
import com.adaming.service.IFraisIncompressiblesService;




@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/fraisincompressibles")
public class FraisIncompressiblesController {

	@Autowired
	IFraisIncompressiblesService fraisIncompressiblesService;

	public FraisIncompressiblesController(FraisIncompressiblesServiceImpl fraisIncompressiblesServiceImpl) {
		this.fraisIncompressiblesService = fraisIncompressiblesServiceImpl;
	}

	@PostMapping(value = "/ajouterFraisIncompressibles", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public FraisIncompressibles saveFraisIncompressible(@RequestBody FraisIncompressibles fraisIncompressibles) {
		return this.fraisIncompressiblesService.saveFraisIncompressible(fraisIncompressibles);
	}
	
	@PutMapping("/{id}")
	public FraisIncompressibles updateFraisIncompressibles (@RequestBody FraisIncompressibles fraisIncompressibles, @PathVariable int id) {
		if(fraisIncompressiblesService.findByIdFraisIncompressible(id)== null) {
			return null;
		} else {
			return fraisIncompressiblesService.saveFraisIncompressible(fraisIncompressibles);
		}
	}
	@DeleteMapping("/{id}")
	public void deleteFraisIncompressibles(@PathVariable int id) {
		if(fraisIncompressiblesService.findByIdFraisIncompressible(id)!= null) {
			fraisIncompressiblesService.deleteFraisIncompressible(fraisIncompressiblesService.findByIdFraisIncompressible(id));
		}
	} 
	
	@GetMapping(value = "/findById/{id}")
	public FraisIncompressibles getById(@PathVariable int id) {
		if(fraisIncompressiblesService.findByIdFraisIncompressible(id)== null) {
			return null;
		} else {
			return fraisIncompressiblesService.findByIdFraisIncompressible(id);
		}
	}
	
	@GetMapping(value = "/all")
	public List<FraisIncompressibles> getAllfraisIncompressibles() {
		List<FraisIncompressibles> fi = fraisIncompressiblesService.findAllFraisIncompressible();
	return fi;
	}

}


