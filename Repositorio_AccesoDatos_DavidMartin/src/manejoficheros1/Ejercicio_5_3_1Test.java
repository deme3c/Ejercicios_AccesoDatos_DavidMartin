package manejoficheros1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

class Ejercicio_5_3_1Test {

	@Test
	void escribirXMLTest() {
		Ejercicio_5_3_1 ej = new Ejercicio_5_3_1();
		File fichero = new File("./tmp/coche322.obj.");
		ej.escribirXML(fichero);
	}

	
	@Test
	void incrementarYearTest() {
		Ejercicio_5_3_1 ej = new Ejercicio_5_3_1();
		ej.incrementarYear();
	}
}
