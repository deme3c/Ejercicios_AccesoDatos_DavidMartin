import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

class mainTeoria1Test {

	@Test
	void crearDirectorioFicheroTest() {
		mainTeoria1 t = new mainTeoria1();
		t.crearFicheroDirectorio();
		
	}
	@Test
	void borrarDirectorioFicheroTest() {
		mainTeoria1.borrarDirectorioFichero();
		
	}
	
	@Test
	void datosFicheroTest() {
		File fichero213 = new File("C:/directorios_y_ficheros/prueba/fichero_prueba.txt");
		mainTeoria1.datosFichero(fichero213);
	}

	@Test
	void mostrarDirectorio() {
		ClaseFileFilter c = new ClaseFileFilter();
		c.mostrarDirectorio("s");
	}
}
