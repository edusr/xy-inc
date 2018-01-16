/**
 * 
 */
package org.edu.xyinc.controllers;

import java.util.List;

import org.edu.xyinc.domains.Product;
import org.edu.xyinc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

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
	
	@PutMapping(path="/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity updateProduct(@RequestBody Product product){
		
		productRepository.save(product);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity saveProduct(@RequestBody Product product){
		
		productRepository.save(product);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

}
