package com.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.adaming.Dao.IClientDao;
import com.adaming.model.Client;
import com.adaming.service.ClientServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceImplTest {

	private ClientServiceImpl clientService;
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientServiceImplTest.class);

	@Mock
	private IClientDao clientDao;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		clientService = new ClientServiceImpl(clientDao);
	}
	
	@Test
	public void should_store_when_save_is_called() {
		LOGGER.info("--------------- Executing should_store_when_save_is_called test Of ClientServiceImplTest ---------------");
		Client client = new Client();
		clientService.saveClient(client);
		Mockito.verify(clientDao).save(client);
	}
	
	@Test
	public void should_update_when_update_is_called() {
		LOGGER.info("--------------- Executing should_update_when_update_is_called test Of ClientServiceImplTest ---------------");
		Client client = new Client();
		clientService.updateClient(client);
		Mockito.verify(clientDao).save(client);
	}
	
	@Test
	public void should_delete_when_delete_is_called() {
		LOGGER.info("--------------- Executing should_delete_when_delete_is_called test Of ClientServiceImplTest ---------------");
		Client client = new Client();
		clientService.deleteClient(client);
		Mockito.verify(clientDao).delete(client);
	}
	
	@Test
	public void should_search_all_when_findAll_is_called() {
		LOGGER.info("--------------- Executing should_search_all_when_findAll_is_called test Of ClientServiceImplTest ---------------");
		clientService.getClient();
		Mockito.verify(clientDao).findAll();
	}
}
