/**
 * 
 */
package org.edu.xyinc.controllers;

import java.util.List;

import org.edu.xyinc.domains.Product;
import org.edu.xyinc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Eduardo Silva Rosa 
 * edus.silva.rosa@gmail.com 
 * 16/01/2018 09:12:19
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping(path = "/all")
	public ResponseEntity<List<Product>> getAllClients() {

		return ResponseEntity.ok().body(productRepository.findAll());
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Product> getClientById(@PathVariable Long id) {

		return ResponseEntity.ok().body(productRepository.findOne(id));
	}
	
	@DeleteMapping(path="/{id}")
	public void deleteProduct(@PathVariable Long id){
		
		productRepository.delete(id);
	}

}
