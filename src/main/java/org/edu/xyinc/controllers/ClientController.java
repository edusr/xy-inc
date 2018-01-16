/**
 * 
 */
package org.edu.xyinc.controllers;

import java.util.List;

import org.edu.xyinc.domains.Client;
import org.edu.xyinc.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Eduardo Silva Rosa
 *         edus.silva.rosa@gmail.com
 * 		   16/01/2018 09:11:46
 */
@Controller
@RequestMapping("/client")
public class ClientController {
	
	@Autowired private ClientRepository clientRepository;
	
	@GetMapping(path = "/all")
	public ResponseEntity<List<Client>> getAllClients() {
		
		return ResponseEntity.ok().body(clientRepository.findAll());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable Long id) {
		
		return ResponseEntity.ok().body(clientRepository.findOne(id));
	}
	
	@DeleteMapping(path="/{id}")
	public void deleteOrder(@PathVariable Long id){
		
		clientRepository.delete(id);
	}

}
