package prArrayAsociativo;

import static org.junit.Assert.*;

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
}
