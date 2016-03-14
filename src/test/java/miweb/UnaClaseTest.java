package miweb;

import static org.junit.Assert.*;

import org.junit.*;

public class UnaClaseTest{


	@Test
	public void unMetodoDevuelve3(){
		UnaClase c = new UnaClase();
		int i = c.unMetodo();
		assertTrue( "El metodo tiene que dar 3:" + i, i == 3 );
	}
    

}