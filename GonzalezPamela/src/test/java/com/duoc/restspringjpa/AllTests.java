package com.duoc.restspringjpa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AgregarTests.class, EliminarTests.class, ListarTests.class, ModificarTests.class,
		ObtenerUnoTests.class })
public class AllTests {

}
