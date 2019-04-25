package com.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.adaming.Dao.IClientDao;
import com.adaming.model.Client;
import com.entity.Client;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientDaoTest {

	@Autowired
	private IClientDao clientDao;

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientDaoTest.class);

	@Test
	public void givenEntityRepository_whenSaving() {
		LOGGER.info("------------ Testing givenEntityRepository_whenSaving Method -------------");
		Client addedClient = clientDao
				.save(new Client(1, "PERRIN", "Pauline", "Clermont city", 25, "25-04-2019", "femme", "06-53-45-48-97"));
		LOGGER.info("---------------- Utilisateur saved ----------------");
		LOGGER.info("---------------- Searching for Utilisateur ----------------");
		Client foundClient = clientDao.findById(addedClient.getId());
		LOGGER.info("---------------- Utilisateur found ----------------");
		LOGGER.info("---------------- Verifying Utilisateur ----------------");
		assertNotNull(foundClient);
		assertEquals(addedClient.getNomClient(), foundClient.getNomClient());
		LOGGER.info("---------------- Utilisateur verified ----------------");
	}

	@Test
	public void givenEntityRepository_whenUpdating() {
		Client addedClient = clientDao
				.save(new Client(1, "PERRIN", "Pauline", "Clermont city", 25, "25-04-2019", "femme", "06-53-45-48-97"));
		Client foundClient = clientDao.findById(addedClient.getId());
		Client addedClient1 = clientDao
				.save(new Client(2, "Marx", "Camille", "Savoie", 26, "25-04-2019", "femme", "06-53-46-48-97"));
		Client foundClient1 = clientDao.findById(addedClient.getId());
		assertNotNull(foundClient1);
		assertNotEquals(addedClient.getNomClient(), addedClient1.getNomClient());
	}

	@Test
	public void givenEntityRepository_whenDeleting() {
		Client addedClient = clientDao
				.save(new Client(2, "Marx", "Camille", "Savoie", 26, "25-04-2019", "femme", "06-53-46-48-97"));
		Client foundClient = clientDao.findById(addedClient.getId());
		clientDao.delete(addedClient);
		Client foundClient1 = clientDao.findById(addedClient.getId());
		assertNotNull(foundClient);
		assertNull(foundClient1);

	}

	@Test
	public void givenEntityRepository_whenRetrievingAll() {

		Client addedClient = clientDao.save(new Client(1, "PERRIN", "Pauline", "Clermont city", 25, "25-04-2019", "femme", "06-53-45-48-97"));
		Client addedClient1 = clientDao.save(new Client(2, "Marx", "Camille", "Savoie", 26, "25-04-2019", "femme", "06-53-46-48-97"));
		Client addedClient2 = clientDao.save(new Client(3, "Durandt", "Etienne", "Savoie", 26, "25-04-2019", "homme", "06-13-56-48-17"));
		assertNotNull(clientDao.findAll());

	}

	@Test
	public void givenEntityRepository_whenRetrievingOneById() {
		Client addedClient = clientDao.save(new Client(1, "PERRIN", "Pauline", "Clermont city", 25, "25-04-2019", "femme", "06-53-45-48-97"));
		Client foundClient = clientDao.findById(addedClient.getId());
		Client addedClient1 = clientDao.save(new Client(2, "Marx", "Camille", "Savoie", 26, "25-04-2019", "femme", "06-53-46-48-97"));
		Client foundClient1 = clientDao.findById(addedClient1.getId());
		Client addedClient2 = clientDao.save(new Client(3, "Durandt", "Etienne", "Savoie", 26, "25-04-2019", "homme", "06-13-56-48-17"));
		Client foundClient2 = clientDao.findById(addedClient2.getId());
		assertNotNull(foundClient);
		assertNotNull(foundClient1);
		assertNotNull(foundClient2);
		assertEquals(addedClient.getNomClient(), foundClient.getNomClient());
		assertEquals(addedClient1.getNomClient(), foundClient1.getNomClient());
		assertEquals(addedClient2.getNomClient(), foundClient2.getNomClient());

	}
}
