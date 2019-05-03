package com.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.adaming.controller.ClientController;
import com.adaming.model.Client;
import com.adaming.service.ClientServiceImpl;
import com.adaming.service.IClientService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ClientControllerTest {

	@Autowired
    private IClientService clientService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientControllerTest.class);
		
		private String uri;
		private MockMvc mvc;
		@Autowired
		WebApplicationContext webApplicationContext;
		

		public ClientControllerTest() {
			this.uri = "/client";
		}

		@Before
		public void setUp() {
			MockitoAnnotations.initMocks(this);
			mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
			
		}
		
		protected final String mapToJson(Object obj) throws JsonProcessingException {
	    	ObjectMapper objectMapper = new ObjectMapper();
	    	return objectMapper.writeValueAsString(obj);
	    }
	    
	    protected final <T> T mapFromJson(String json, Class<T> clazz)
	    throws JsonParseException, JsonMappingException, IOException {
	    	ObjectMapper objectMapper = new ObjectMapper();
	    	return objectMapper.readValue(json,  clazz);
	    }
	    
		@Test
		public void save() {
			LOGGER.info("--------Testing save Method -------");
	    	LOGGER.info("--------Constructing Client -------");
				Client myClient = new Client(1, "Perrin", "Pauline", "clermont", 25, "27/04/2019", "femme",
						"06-58-58-96-23");
				MvcResult mvcResult;
				try {
					LOGGER.info("--------Serializing Client Object -------");
		    		String inputJson = this.mapToJson(myClient);
		    		LOGGER.info("-------- Mocking Context Webservice and invoking the webservice -------");
		    		mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri + "/ajouterClient").contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		    		LOGGER.info("--------Getting HTTP Status -------");
		    		int status = mvcResult.getResponse().getStatus();
		    		LOGGER.info("--------Verrifying HTTP Status -------");
		    		assertEquals(200, status);
		    		LOGGER.info("--------Searching for Client -------");
		    		Client ClientFound = clientService.findByIdClient(new Integer(1));
		    		LOGGER.info("--------Verrifying Client -------");
		    		assertEquals(ClientFound.getNomClient(), myClient.getNomClient());
		    	}catch (Exception e) {
		    		e.printStackTrace();
		    	}
		    }
				
				
		
		@Test
		public void update() {
	    	try {
				LOGGER.info("--------Testing update Method -------");
				LOGGER.info("--------Constructing Client -------");
				Client myClient = new Client(1, "Perrin", "Pauline", "clermont", 25, "27/04/2019", "femme",
						"06-58-58-96-23");
				LOGGER.info("--------Saving Client -------");
				clientService.saveClient(myClient);
				LOGGER.info("--------Modifying Client -------");
				Client newClient = new Client(1, "Marx", "Camille", "Lyon", 25, "27/04/2019", "femme",
						"06-58-58-96-24");
				LOGGER.info("--------Serializing Client Object-------");
				String inputJson = this.mapToJson(newClient);
				LOGGER.info("--------Mocking Context Webservice and invoking the webservice -------");
				MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri + "/1").contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
				LOGGER.info("-------- Getting HTTP Status-------");
				int status = mvcResult.getResponse().getStatus();
				LOGGER.info("--------Verifyng HTTP Status -------");
				assertEquals(200, status);
				LOGGER.info("--------Searching for Client -------");
	    		Client ClientFound = clientService.findByIdClient(new Integer(1));
	    		LOGGER.info("--------Verrifying Client -------");
	    		assertEquals(ClientFound.getNomClient(), newClient.getNomClient());
	    	}catch (Exception e) {
				e.printStackTrace();
			}
	    }
		
		@Test
	    public void delete() {
	        try {
	        	LOGGER.info("----------Testing delete Method-----------");
	        	LOGGER.info("--------Constructing Client -------");
	        	Client myClient = new Client(1, "Perrin", "Pauline", "clermont", 25, "27/04/2019", "femme",
						"06-58-58-96-23");
				LOGGER.info("--------Saving Client -------");
				clientService.saveClient(myClient);
				LOGGER.info("----------Mocking Context Webservice and invoking the webservice-----------");
	            MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri + "/1")).andReturn();
	            LOGGER.info("----------Getting HTTP Status-----------");
	            int status = mvcResult.getResponse().getStatus();
	            LOGGER.info("----------Verrifying HTTP Status-----------");
	            assertEquals(200, status);
	            LOGGER.info("----------Searching for Utilisateur-----------");
	            Client ClientFound = clientService.findByIdClient(new Integer(1));
	            LOGGER.info("----------Verifying utilisateur-----------");
	            assertEquals(ClientFound, null);
	        }catch (Exception e) {
	            e.printStackTrace();

	        }
	    }
		
		 @Test
		    public void findByIdClient() {
		    	MvcResult mvcResult;
		    	try {
		    		LOGGER.info("--------Testing findById Method -------");
		    		LOGGER.info("--------Constructing Client -------");
		    		Client myClient = new Client(1, "Perrin", "Pauline", "clermont", 25, "27/04/2019", "femme",
							"06-58-58-96-23");
					LOGGER.info("--------Saving Client -------");
					clientService.saveClient(myClient);
					LOGGER.info("--------Mocking Context Webservice -------");
		    		mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri + "/1").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		    		LOGGER.info("--------Getting HTTP Status -------");
		    		int status = mvcResult.getResponse().getStatus();
		    		LOGGER.info("--------Verifying HTTP Status -------");
		    		assertEquals(200, status);
		    		LOGGER.info("----------Searching for Client-----------");
		            Client ClientFound = clientService.findByIdClient(myClient.getId());
		            LOGGER.info("----------Verifying client-----------");
		            assertEquals(ClientFound.getId(), myClient.getId()); 
		    	}catch (Exception e) {
		    		e.printStackTrace();
		    	}
		    }
		
		
		   @Test
		    public void findAll() {
		    	MvcResult mvcResult;
		    	try {
		    		LOGGER.info("--------Testing findAll Method -------");
		    		LOGGER.info("--------Constructing Client -------");
		    		Client myClient = new Client(1, "Perrin", "Pauline", "clermont", 25, "27/04/2019", "femme",
							"06-58-58-96-23");
					LOGGER.info("--------Saving Client -------");
					clientService.saveClient(myClient);
					LOGGER.info("--------Mocking Context Webservice -------");
		    		mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri + "/Clients").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		    		LOGGER.info("--------Getting HTTP Status -------");
		    		int status = mvcResult.getResponse().getStatus();
		    		LOGGER.info("--------Verifying HTTP Status -------");
		    		assertEquals(200, status);
		    		LOGGER.info("--------Getting HTTP Response -------");
		    		String content = mvcResult.getResponse().getContentAsString();
		    		LOGGER.info("--------Deserializing JSON Response -------");
		    		Client[] ClientList = this.mapFromJson(content, Client[].class);
		    		assertTrue(ClientList.length > 0);
		    	}catch (Exception e) {
		    		e.printStackTrace();
		    	}
		    }
		

		

	
	}

