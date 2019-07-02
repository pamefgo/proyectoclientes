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
public class ObtenerUnoTests {
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
	public void cuandoBuscoUnoEntoncesNotNull() {
		assertNotNull(this.dao.findById("15884806-1"));
	}
	@Test
	public void cuandoBuscoUnoEntoncesNull() {
		assertNull(this.dao.findById("2405485-k").orElse(null));
	}
	@Test
	public void cuandoComparoClienteEntoncesTrue() {
		Cliente juan=this.dao.findById("15884806-1").get();
		Cliente cliente=new Cliente("15884806-1","Juan","Perez","juan@gmail.com","+5695456764");
		boolean sonIguales=juan.equals(cliente);
		assertTrue(sonIguales);
	}

}
