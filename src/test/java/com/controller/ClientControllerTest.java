package com.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.adaming.controller.ClientController;
import com.adaming.model.Client;
import com.adaming.service.ClientServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientControllerTest {

		private static final Logger LOGGER = LoggerFactory.getLogger(ClientControllerTest.class);
		private MvcResult mvcResult;
		private String uri;
		private MockMvc mvc;
		@Autowired
		WebApplicationContext webApplicationContext;
		@Mock
		ClientServiceImpl clientServiceImpl;
		ClientController clientController;

		public ClientControllerTest() {
			this.uri = "/client";
		}

		@Before
		public void setUp() {
			MockitoAnnotations.initMocks(this);
			mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
			clientController = new ClientController(clientServiceImpl);
		}
		
		@Test
		public void should_have_200_status_when_ajouterClient_is_called() {
			LOGGER.info(
					"--------------- Executing should_have_200_status_when_createClient_is_called test Of ClientServiceImplTest ---------------");
			try {
				Client myClient = new Client(1, "Perrin", "Pauline", "clermont", 25, "27/04/2019", "femme",
						"06-58-58-96-23");
				ObjectMapper objectMapper = new ObjectMapper();
				String inputJson = objectMapper.writeValueAsString(myClient);
				mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri + "/ajouterClient")
						.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
				assertEquals(200, mvcResult.getResponse().getStatus());
			} catch (Exception e) {
				LOGGER.error("An exception occured");
				e.printStackTrace();
			}
		}

		@Test
		public void should_use_save_when_ajouterClient_is_called() {
			LOGGER.info(
					"--------------- Executing should_use_save_when_ajouterClient_is_called test Of ClientServiceImplTest ---------------");
			Client myClient = new Client(1, "Perrin", "Pauline", "clermont", 25, "27/04/2019", "femme",
					"06-58-58-96-23");
			clientController.createClient(myClient);
			verify(clientServiceImpl).saveClient(myClient);
		}
		
		@Test
		public void should_have_200_status_when_updateClient_is_called() {
			LOGGER.info(
					"--------------- Executing should_have_200_status_when_modifierClient_is_called test Of ClientServiceImplTest ---------------");
			try {
				Client myClient = new Client(1, "Perrin", "Pauline", "clermont", 25, "27/04/2019", "femme",
						"06-58-58-96-23");
				ObjectMapper objectMapper = new ObjectMapper();
				String inputJson = objectMapper.writeValueAsString(myClient);
				MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri + "/modifierClient")
						.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
				assertEquals(200, mvcResult.getResponse().getStatus());
			} catch (Exception e) {
				LOGGER.error("An exception occured");
				e.printStackTrace();
			}
		}

		@Test
		public void should_use_update_when_updateClient_is_called() {
			LOGGER.info(
					"--------------- Executing should_use_update_when_updateClient_is_called test Of ClientServiceImplTest ---------------");
			Client myClient = new Client(1, "Perrin", "Pauline", "clermont", 25, "27/04/2019", "femme",
					"06-58-58-96-23");
			clientController.updateClient(myClient);
			verify(clientServiceImpl).updateClient(myClient);
		}
		
		@Test
		public void should_have_200_status_when_getClientById_is_called() {
			LOGGER.info(
					"--------------- Executing should_have_200_status_when_getClientById_is_called test Of KnowledgeControllerTest ---------------");
			try {
				ObjectMapper objectMapper = new ObjectMapper();
				String inputJson = objectMapper.writeValueAsString(1);
				mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri + "/getClientById")
						.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

				assertEquals(200, mvcResult.getResponse().getStatus());
			} catch (Exception e) {
				LOGGER.error("An exception occured");
				e.printStackTrace();
			}
		}

		@Test
		public void should_use_findAll_when_getClientById_is_called() {
			LOGGER.info(
					"--------------- Executing should_use_findAll_when_getKnowledgeById_is_called test Of KnowledgeControllerTest ---------------");
			clientController.getClientById(1);
			verify(clientServiceImpl).findByIdClient(1);
		}
		
		@Test
		public void should_have_200_status_when_getAllClients_is_called() {
			LOGGER.info(
					"--------------- Executing should_have_200_status_when_getAllClients_is_called test Of ProjectControllerTest ---------------");
			try {
				mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri + "/Clients")
						.contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();
				assertEquals(200, mvcResult.getResponse().getStatus());
			} catch (Exception e) {
				LOGGER.error("An exception occured");
				e.printStackTrace();
			}
		}

		@Test
		public void should_use_search_all_when_getAllClients_is_called() {
			LOGGER.info(
					"--------------- Executing should_use_search_all_when_getAllProjects_is_called test Of ProjectControllerTest ---------------");
			clientController.getAllClients();
			verify(clientServiceImpl).findAllClient();
		}

		

	
	}

