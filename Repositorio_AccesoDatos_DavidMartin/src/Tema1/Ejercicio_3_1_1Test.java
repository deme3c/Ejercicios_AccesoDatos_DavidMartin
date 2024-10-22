package Tema1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

class Ejercicio_3_1_1Test {

	@Test
	void escribirCadenaTest() {
		Ejercicio_3_1_1 ej = new Ejercicio_3_1_1();
		ej.escribirCadena("./tmp/311.txt", "Voy a escribir esta cadena para el primer apartado del ejercicio 311");
	}
	
	@Test
	void addNamesTest() {
		Ejercicio_3_1_1 ej = new Ejercicio_3_1_1();
		ej.addNames("./tmp/311.txt");
	}
	
	@Test
	void leerFicheroTest() {
		Ejercicio_3_1_1 ej = new Ejercicio_3_1_1();
		File fichero = new File("./tmp/311.txt");
		ej.leerFichero(fichero);
	}
}
