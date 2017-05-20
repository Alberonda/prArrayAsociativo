package prArrayAsociativo;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class TestArray {

	@Test
	public void testSizevacio() {
		ArrayAsociativo a = new ArrayAsociativo();
		assertEquals(new Integer(0), new Integer (a.size()));
	}
	
	@Test
	public void testSizenovacio() {
		String[] claves = {"hola","aaa"};
		String[] valores = {"adios","bbb"};
		ArrayAsociativo a = new ArrayAsociativo(claves,valores);
		assertNotEquals(new Integer(0), new Integer (a.size()));
	}
	

	@Test
	public void testBuscarVacio() {
		try {
			ArrayAsociativo a = new ArrayAsociativo();
			a.get("hola").equals("adios");
		}
	 	catch(NoSuchElementException e) {
		 	assertTrue(true);
	 	}
	}
	
	@Test
	public void testBuscarExiste() {
		String[] claves = {"hola","aaa"};
		String[] valores = {"adios","bbb"};
		ArrayAsociativo a = new ArrayAsociativo(claves,valores);
		assertTrue("Iguales", new String("adios").equals(a.get("hola")));
	}
	
	@Test
	public void testBuscarNoExiste() {
		try {
			String[] claves = {"hola","aaa"};
			String[] valores = {"adios","bbb"};
			ArrayAsociativo a = new ArrayAsociativo(claves,valores);
			a.get("falta").equals("adios");
		}
	 	catch(NoSuchElementException e) {
		 	assertTrue(true);
	 	}
	}
	
	@Test
	public void testInsertaVacio() {
		String[] claves = {};
		String[] valores = {};
		ArrayAsociativo a = new ArrayAsociativo(claves,valores);
		a.put("hola","adios");
		assertEquals(new String("adios"),new String(a.get("hola")));
	}
	
	@Test
	public void testInsertaConElem() {
		String[] claves = {"aaa"};
		String[] valores = {"bbb"};
		ArrayAsociativo a = new ArrayAsociativo(claves,valores);
		a.put("hola","adios");
		assertEquals(new String("adios"),new String(a.get("hola")));
	}
	
	@Test
	public void testInsertaDuplicado() {
		String[] claves = {"aaa"};
		String[] valores = {"bbb"};
		ArrayAsociativo a = new ArrayAsociativo(claves,valores);
		a.put("aaa","adios");
		assertEquals(new String("adios"),new String(a.get("aaa")));
	}
	
	@Test
	public void testgetOrElseVacio() {
		ArrayAsociativo a = new ArrayAsociativo();
		assertEquals(new String("defecto"),new String(a.getOrElse("hola","defecto")));
	}
	
	@Test
	public void testgetOrElseEncontrado() {
		String[] claves = {"aaa"};
		String[] valores = {"bbb"};
		ArrayAsociativo a = new ArrayAsociativo(claves,valores);
		assertEquals(new String("bbb"),new String(a.getOrElse("aaa", "defecto")));
	}
	
	
	
	
	
	
	
	
	
	

}