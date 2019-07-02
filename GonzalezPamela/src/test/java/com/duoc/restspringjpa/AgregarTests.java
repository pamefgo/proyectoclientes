package com.duoc.restspringjpa;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.duoc.restspringjpa.modelo.Cliente;
import com.duoc.restspringjpa.modelo.IClienteDao;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AgregarTests {
	@Autowired
	TestEntityManager em;
	@Autowired
	IClienteDao dao;

	@Before
	public void setUp() throws Exception {
		Cliente cliente=new Cliente("15884806-1","Juan","Perez","juan@gmail.com","+5695456764");
		this.em.persist(cliente);
		cliente=new Cliente("12883406-5","Pedro","Zuñiga","pedro@gmail.com","+5665856764");
		this.em.persist(cliente);
		cliente=new Cliente("19884845-0","Diego","Lopez","diego@gmail.com","+5695456764");
		this.em.persist(cliente);
	}

	@Test
	public void cuandoInsertaEntoncesRetornaNotNull() {
		this.dao.save(new Cliente("9230533-1","Maria","Perez","maria@gmail.com","+5695456764"));
		assertNotNull(this.dao.findById("9230533-1"));
	}
	
	@Test
	public void cuandoInsertaEntoncesRetorna4Clientes() {
		this.dao.save(new Cliente("9230533-1","Maria","Perez","maria@gmail.com","+5695456764"));
		int largo=this.dao.findAll().size();
		assertTrue("SON "+largo+" DEBERIAN SER 4",largo==4);
	}

	@Test
	public void cuandoInserta2EntoncesRetorna5TRUE() {
		this.dao.save(new Cliente("9230533-1","Maria","Perez","maria@gmail.com","+5695456764"));
		this.dao.save(new Cliente("8705368-7","Jesus","Osorio","jesus@gmail.com","+5695456764"));
		int largo=this.dao.findAll().size();
		assertTrue("SON "+largo+" DEBERIAN SER 5",largo==5);
	}
	
	

}
