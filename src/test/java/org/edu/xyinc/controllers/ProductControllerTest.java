/**
 * 
 */
package org.edu.xyinc.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.math.BigDecimal;

import org.edu.xyinc.XyIncApplication;
import org.edu.xyinc.domains.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.NestedServletException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Eduardo Silva Rosa
 *         edus.silva.rosa@gmail.com
 *         17/01/2018 11:20:01
 */
@RunWith( SpringRunner.class )
@SpringBootTest( classes = XyIncApplication.class )
@WebAppConfiguration
public class ProductControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() throws Exception {

        this.mockMvc = webAppContextSetup( webApplicationContext ).build();
    }

    @Test
    public void allProductTest() throws Exception {

        this.mockMvc.perform( get( "/product/all" ).accept( MediaType.APPLICATION_JSON ) ).andExpect( status().isOk() );
    }

    @Test
    public void saveProductsOk() throws Exception {

        Product product = new Product();
        product.setName( "Cel Phone" );
        product.setBarcode( "7898080640222" );
        product.setPrice( new BigDecimal( 4025.25 ) );

        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = mapper.writeValueAsString( product );

        this.mockMvc.perform( post( "/product" ).contentType( MediaType.APPLICATION_JSON ).content( jsonResult ) )
            .andExpect( status().isOk() );

    }
    
    @Test(expected=NestedServletException.class)
    public void saveProductsWithoutName() throws Exception {

        Product product = new Product();
        product.setBarcode( "7898080640222" );
        product.setPrice( new BigDecimal( 4025.25 ) );

        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = mapper.writeValueAsString( product );

        this.mockMvc.perform( post( "/product" ).contentType( MediaType.APPLICATION_JSON ).content( jsonResult ) )
            .andExpect( status().is( 500 ) );

    }
    
    @Test
    public void findProductByIdTest() throws Exception {

        this.mockMvc.perform( get( "/product/1" ).accept( MediaType.APPLICATION_JSON ) ).andExpect( status().isOk() );
    }
    
    
    @Test
    public void deleteProductsOk() throws Exception {

        this.mockMvc.perform( delete( "/product/1" ))
            .andExpect( status().isOk() );

    }

}
