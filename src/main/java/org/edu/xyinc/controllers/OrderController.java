/**
 * 
 */
package org.edu.xyinc.controllers;

import java.util.List;

import org.edu.xyinc.domains.Order;
import org.edu.xyinc.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Eduardo Silva Rosa
 *		   edus.silva.rosa@gmail.com
 * 		   16/01/2018 09:12:02
 */
@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired private OrderRepository orderRepository;
	
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

}
