package prArrayAsociativo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestArray {

	@Test
	public void testSizevacio() {
		String[] claves = {"hola"};
		String[] valores = {"adios"};
		ArrayAsociativo a = new ArrayAsociativo();
		assertEquals(new Integer(0), new Integer (a.size()));
	}
}
