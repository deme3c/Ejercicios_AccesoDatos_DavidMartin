package manejoficheros1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

class Ejercicio_2_1_4Test {

	void mostrarSizeDirectorioPadreTest() {
		File fichero214 = new File(
				"C:\\Users\\dmart\\eclipse-workspace\\carreraCaballos\\src\\carreraCaballos\\Caballo.java");
		Ejercicio_2_1_4.mostrarSizeDirectorioPadre(fichero214);
	}

}
