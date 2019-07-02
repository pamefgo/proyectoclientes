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
public class ModificarTests {
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
	public void cuandoModificaNombreRegistroNotNull() {
		this.dao.save(new Cliente("15884806-1","Victor","Perez","juan@gmail.com","+5695456764"));
		assertNotNull(this.dao.findById("15884806-1"));
	}
	
	@Test
	public void cuandoModificaMantieneCantidadDeClientesEntoncesTrue() {
		this.dao.save(new Cliente("15884806-1","Victor","Perez","juan@gmail.com","+5695456764"));
		int largo=this.dao.findAll().size();
		assertTrue("SON "+largo+" DEBERIAN SER 3",largo==3);
	}

}
