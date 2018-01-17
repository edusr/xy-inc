/**
 * 
 */
package org.edu.xyinc.controllers;

import java.util.List;

import org.edu.xyinc.domains.Client;
import org.edu.xyinc.exceptionhandler.XyApplicationException;
import org.edu.xyinc.repository.ClientRepository;
import org.edu.xyinc.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Eduardo Silva Rosa
 *         edus.silva.rosa@gmail.com
 * 		   16/01/2018 09:11:46
 */
@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired private ClientRepository clientRepository;
	
	@Autowired private ClientService clientService;
	
	@GetMapping(path = "/all")
	public ResponseEntity<List<Client>> getAllClients() {
		
		return ResponseEntity.ok().body(clientRepository.findAll());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable Long id) {
		
		return ResponseEntity.ok().body(clientRepository.findOne(id));
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity< ? > deleteClient(@PathVariable Long id){
		
		clientRepository.delete(id);
		return ResponseEntity.ok().build();
	}
	
    @PutMapping( path = "/{id}" )
    public ResponseEntity< ? > updateClient( @RequestBody Client client ) throws XyApplicationException {

        clientService.saveClient( client );
        return ResponseEntity.ok().body( null );
    }

    @PostMapping( consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
    public ResponseEntity< ? > saveClient( @RequestBody Client client ) throws XyApplicationException {

        clientService.saveClient( client );
        return ResponseEntity.ok().body( null );
    }


}
