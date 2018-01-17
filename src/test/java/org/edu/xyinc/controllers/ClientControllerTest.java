/**
 * 
 */
package org.edu.xyinc.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.edu.xyinc.XyIncApplication;
import org.edu.xyinc.domains.Adress;
import org.edu.xyinc.domains.Client;
import org.edu.xyinc.exceptionhandler.XyApplicationException;
import org.edu.xyinc.repository.ClientRepository;
import org.edu.xyinc.services.ClientService;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
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
@FixMethodOrder( MethodSorters.NAME_ASCENDING )
public class ClientControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    ClientService clientService;

    @Autowired
    ClientRepository clientRepository;

    @Before
    public void setup() throws Exception {

        this.mockMvc = webAppContextSetup( webApplicationContext ).build();
    }

    @Test
    public void saveClientOk() throws Exception {

        Client client = new Client();
        client.setName( "Eduardo" );
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

        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = mapper.writeValueAsString( client );

        this.mockMvc.perform( post( "/client" ).contentType( MediaType.APPLICATION_JSON ).content( jsonResult ) )
            .andExpect( status().isOk() );

    }

    @Test
    public void allProductTest() throws Exception {

        this.mockMvc.perform( get( "/client/all" ).accept( MediaType.APPLICATION_JSON ) ).andExpect( status().isOk() );
    }

    @Test
    public void updateClientOk() throws Exception {
        
        saveClientOneIfNotExists();

        Client client = new Client();
        client.setId( 1L );
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

        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = mapper.writeValueAsString( client );

        this.mockMvc.perform( put( "/client/1" ).contentType( MediaType.APPLICATION_JSON ).content( jsonResult ) )
            .andExpect( status().isOk() );

    }

    @Test( expected = NestedServletException.class )
    public void saveClientWithoutName() throws Exception {

        Client client = new Client();
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

        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = mapper.writeValueAsString( client );

        this.mockMvc.perform( post( "/product" ).contentType( MediaType.APPLICATION_JSON ).content( jsonResult ) )
            .andExpect( status().is( 500 ) );

    }

    @Test
    public void findClientByIdTest() throws Exception {

        this.mockMvc.perform( get( "/client/1" ).accept( MediaType.APPLICATION_JSON ) ).andExpect( status().isOk() );
    }

    @Test
    public void deleteClientOk() throws Exception {
        
        saveClientOneIfNotExists();

        this.mockMvc.perform( delete( "/client/1" ) ).andExpect( status().isOk() );

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

}
