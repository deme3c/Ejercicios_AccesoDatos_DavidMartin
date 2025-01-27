package manejoficheros1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Ejercicio_2_1_2Test {

	@Test
	void crearDirectorioFicheroTest() {
		Ejercicio_2_1_2 t = new Ejercicio_2_1_2();
		t.crearFicheroDirectorio();
		
	}
	@Test
	void borrarDirectorioFicheroTest() {
		Ejercicio_2_1_2.borrarDirectorioFichero();
		
	}

}
