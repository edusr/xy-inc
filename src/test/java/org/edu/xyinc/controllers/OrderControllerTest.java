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
import org.edu.xyinc.domains.Adress;
import org.edu.xyinc.domains.Client;
import org.edu.xyinc.domains.Order;
import org.edu.xyinc.domains.OrderItem;
import org.edu.xyinc.domains.Product;
import org.edu.xyinc.exceptionhandler.XyApplicationException;
import org.edu.xyinc.repository.ClientRepository;
import org.edu.xyinc.repository.OrderRepository;
import org.edu.xyinc.repository.ProductRepository;
import org.edu.xyinc.services.ClientService;
import org.edu.xyinc.services.OrderService;
import org.edu.xyinc.services.ProductService;
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

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Eduardo Silva Rosa
 *         edus.silva.rosa@gmail.com
 *         17/01/2018 11:20:01
 */
@RunWith( SpringRunner.class )
@SpringBootTest( classes = XyIncApplication.class )
@WebAppConfiguration
public class OrderControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;
    
    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientRepository clientRepository;
    
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @Before
    public void setup() throws Exception {

        this.mockMvc = webAppContextSetup( webApplicationContext ).build();
        saveClientOneIfNotExists();
        saveProductOneIfNotExists();
    }

    @Test
    public void allOrderTest() throws Exception {

        this.mockMvc.perform( get( "/order/all" ).accept( MediaType.APPLICATION_JSON ) ).andExpect( status().isOk() );
    }

    @Test
    public void saveOrderOk() throws Exception {

        Order order = new Order();
        
        Client client = new Client();
        client.setId( 1L );
        
        Product product = new Product();
        product.setId( 1L );
        product.setPrice( new BigDecimal( 4025.25 ) );
        
        order.setClient( client );
        
        OrderItem orderItem = new OrderItem();
        
        orderItem.setProduct( product );
        orderItem.setUnityPrice( product.getPrice() );
        orderItem.setQuantity( 10L );
        
        order.addItem( orderItem );
        

        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = mapper.writeValueAsString( order );

        this.mockMvc.perform( post( "/order" ).contentType( MediaType.APPLICATION_JSON ).content( jsonResult ) )
            .andExpect( status().isOk() );

    }
    
    @Test
    public void findOrderByIdTest() throws Exception {

        this.mockMvc.perform( get( "/order/1" ).accept( MediaType.APPLICATION_JSON ) ).andExpect( status().isOk() );
    }
    
    
    @Test
    public void deleteOrderOk() throws Exception {
        
        saveOrdOneIfNotExists();

        this.mockMvc.perform( delete( "/order/1" ))
            .andExpect( status().isOk() );

    }
    
    private void saveClientOneIfNotExists() throws XyApplicationException {

        if(clientRepository.findOne( 1L ) == null) {
            Client client = new Client();
            client.setName( "Eduardo Silva" );
            client.setDocument( "5651316574798" );
            client.setEmail( "test@teste.com" );
            client.setPhone( "34991999999" );

            Adress adress = new Adress();
            adress.setCity( "uberlandia" );
            adress.setCountry( "Brasil" );
            adress.setNeighborhood( "Umuarama" );
            adress.setNumber( "1" );
            adress.setState( "Minas Gerais" );
            adress.setStreet( "Rua 1" );
            
            client.setAdress( adress );
            
            clientService.saveClient( client );
        }
    }
    
    private void saveProductOneIfNotExists() throws XyApplicationException {
        if(productRepository.findOne( 1L ) == null) {
        Product product = new Product();
        product.setName( "Cel Phone" );
        product.setBarcode( "7898080640222" );
        product.setPrice( new BigDecimal( 4025.25 ) );
        
        productService.saveProduct( product );
        }
        
    }
    
    private void saveOrdOneIfNotExists() throws XyApplicationException {
        if(orderRepository.findOne( 1L ) == null) {
            Order order = new Order();
            
            Client client = new Client();
            client.setId( 1L );
            
            Product product = new Product();
            product.setId( 1L );
            product.setPrice( new BigDecimal( 4025.25 ) );
            
            order.setClient( client );
            
            OrderItem orderItem = new OrderItem();
            
            orderItem.setProduct( product );
            orderItem.setUnityPrice( product.getPrice() );
            orderItem.setQuantity( 10L );
            
            order.addItem( orderItem );
        
        orderService.saveOrder( order );
        }
        
    }

}
