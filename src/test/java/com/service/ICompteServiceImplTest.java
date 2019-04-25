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

import com.SpringBootRunner;
import com.adaming.Dao.ICompteBancaireDao;
import com.adaming.model.CompteBancaire;
import com.adaming.service.CompteServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootRunner.class)
public class ICompteServiceImplTest {
	
	private CompteServiceImpl ICompteService;
	private static final Logger LOGGER = LoggerFactory.getLogger(ICompteServiceImplTest.class);

	@Mock
	private ICompteBancaireDao iCBDao;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		ICompteService = new CompteServiceImpl(iCBDao);
	}

	@Test
	public void should_store_when_save_is_called() {
		LOGGER.info("--------------- Executing should_store_when_save_is_called test Of ClientServiceImplTest ---------------");
		CompteBancaire compte = new CompteBancaire();
		ICompteService.saveCompteBancaire(compte);
		Mockito.verify(iCBDao).save(compte);
	}
}
