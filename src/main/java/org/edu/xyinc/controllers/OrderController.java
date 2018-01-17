/**
 * 
 */
package org.edu.xyinc.controllers;

import java.util.List;

import org.edu.xyinc.domains.Order;
import org.edu.xyinc.exceptionhandler.XyApplicationException;
import org.edu.xyinc.repository.OrderRepository;
import org.edu.xyinc.services.OrderService;
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
 *		   edus.silva.rosa@gmail.com
 * 		   16/01/2018 09:12:02
 */
@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired private OrderRepository orderRepository;
	
	@Autowired private OrderService orderService;
	
	@GetMapping(path = "/all")
	public ResponseEntity<List<Order>> getAllClients() {
		
			return ResponseEntity.ok().body(orderRepository.findAll());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Order> getClientById(@PathVariable Long id) {
		
		return ResponseEntity.ok().body(orderRepository.findOne(id));
	}
	
	@DeleteMapping(path="/{id}")
	public void deleteOrder(@PathVariable Long id){
		
		orderRepository.delete(id);
	}
	
    @PutMapping( path = "/{id}" )
    public ResponseEntity< ? > updateClient( @RequestBody Order order ) throws XyApplicationException {

        orderService.saveOrder( order );
        return ResponseEntity.ok().body( null );
    }

    @PostMapping( consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
    public ResponseEntity< ? > saveClient( @RequestBody Order order ) throws XyApplicationException {

        orderService.saveOrder( order );
        return ResponseEntity.ok().body( null );
    }

}
