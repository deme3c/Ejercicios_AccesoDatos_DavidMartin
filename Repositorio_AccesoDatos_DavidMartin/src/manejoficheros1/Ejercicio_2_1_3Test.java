package manejoficheros1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

class Ejercicio_2_1_3Test {

	void datosFicheroTest() {
		File fichero213 = new File("C:/directorios_y_ficheros/prueba/fichero_prueba.txt");
		Ejercicio_2_1_3.datosFichero(fichero213);
	}

}
