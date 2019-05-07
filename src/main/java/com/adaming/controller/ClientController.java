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
        
         @PostMapping(value = "/ajouterClient",
                    consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
            public Client addNewClient(@RequestBody Client Client) {
                return this.clientService.saveClient(Client);
              
            }

         @PutMapping("/{id}")
            public Client updateClient (@RequestBody Client Client, @PathVariable int id){
                if(clientService.findByIdClient(id)== null) {
                    return null;
                }else {
                    return clientService.saveClient(Client);
                }
            }
            
            @DeleteMapping("/{id}")
            public void deleteClient(@PathVariable int id) {
                if(clientService.findByIdClient(id)!= null) {
                     clientService.deleteClient(clientService.findByIdClient(id));
                }
            }
        
         @GetMapping(value = "/findByIdClient/{id}")
            public Client getById(@PathVariable int id) {
                if(clientService.findByIdClient(id)== null) {
                    return null;
                }else {
                    return clientService.findByIdClient(id) ;
                }    }
        
         @GetMapping(value = "/Clients")
            public List<Client> findAllClient() {
                List<Client> clients =  clientService.findAllClient();
                return clients;
            }


        
        
        
    }
