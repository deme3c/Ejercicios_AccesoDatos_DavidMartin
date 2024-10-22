package Tema1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Ejercicio_3_2_1Test {

	@Test
	void guardarCocheTest() {
		Ejercicio_3_2_1 ej = new Ejercicio_3_2_1();
		ej.guardarCoche("1234ABC", "Toyota", 2015);
		ej.guardarCoche("5678DEF", "Honda", 2018);
		ej.guardarCoche("9101GHI", "Ford", 2020);
	}
	
	@Test
	void leerCochesTest() {
		Ejercicio_3_2_1 ej = new Ejercicio_3_2_1();
		ej.leerCoches();
	}

}