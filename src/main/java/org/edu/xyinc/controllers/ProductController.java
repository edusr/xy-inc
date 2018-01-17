/**
 * 
 */
package org.edu.xyinc.controllers;

import java.util.List;

import org.edu.xyinc.domains.Product;
import org.edu.xyinc.exceptionhandler.XyApplicationException;
import org.edu.xyinc.repository.ProductRepository;
import org.edu.xyinc.services.ProductService;
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
 *         16/01/2018 09:12:19
 */
@RestController
@RequestMapping( "/product" )
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @GetMapping( path = "/all" )
    public ResponseEntity< List< Product > > getAllClients() {

        return ResponseEntity.ok().body( productRepository.findAll() );
    }

    @GetMapping( path = "/{id}" )
    public ResponseEntity< Product > getProductcleById( @PathVariable Long id ) {

        return ResponseEntity.ok().body( productRepository.findOne( id ) );
    }

    @DeleteMapping( path = "/{id}" )
    public void deleteProduct( @PathVariable Long id ) {

        productRepository.delete( id );
    }

    @PutMapping( path = "/{id}" )
    public ResponseEntity< ? > updateProduct( @RequestBody Product product ) throws XyApplicationException {

        productService.saveProduct( product );
        return ResponseEntity.ok().body( null );
    }

    @PostMapping( consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
    public ResponseEntity< ? > saveProduct( @RequestBody Product product ) throws XyApplicationException {

        productService.saveProduct( product );
        return ResponseEntity.ok().body( null );
    }

}
