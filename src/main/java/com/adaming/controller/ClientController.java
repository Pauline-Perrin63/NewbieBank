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

import com.adaming.model.Client;
import com.adaming.service.ClientServiceImpl;
import com.adaming.service.IClientService;

@RestController
@CrossOrigin
@RequestMapping("/client")
public class ClientController {


		@Autowired
		IClientService clientService;

		public ClientController(ClientServiceImpl clientServiceImpl) {
			this.clientService = clientServiceImpl;
		}

		@RequestMapping(value = "/ajouterClient", method = RequestMethod.POST)
		public ResponseEntity<Client> createClient(@RequestBody Client client) {
			client = this.clientService.saveClient(client);
			return new ResponseEntity<Client>(client, HttpStatus.OK);
		}
		
		@RequestMapping(value = "/modifierClient", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Client> updateClient(@RequestBody Client Client) {
			Client = this.clientService.updateClient(Client);
			return new ResponseEntity<Client>(Client, HttpStatus.OK);
		}
		
		@RequestMapping(value = "/supprimerClient", method = RequestMethod.DELETE)
		public ResponseEntity<Client> deleteClient(@RequestBody Client client) {
			this.clientService.deleteClient(client);
			return new ResponseEntity<Client>(client, HttpStatus.OK);
		}
		
		@RequestMapping(value = "/getClientById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Client> getClientById(@RequestBody Integer id) {
			Client Client = this.clientService.findByIdClient(id);
			return new ResponseEntity<Client>(Client, HttpStatus.OK);
		}
		
		@RequestMapping(value = "/Clients", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Client>> getAllClients() {
			List<Client> Clients = this.clientService.findAllClient();
			return new ResponseEntity<List<Client>>(Clients, HttpStatus.OK);
		}
	}

