package manejoficheros1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Ejercicio_3_2_2Test {

	@Test
	void guardarCocheTest() {
		Ejercicio_3_2_2 ej = new Ejercicio_3_2_2();
		String matriculas[] ={"1234","2345","5t6y"};
		String marca[]= {"peugeot","mazda","mercedes"};
		int year[]= {1,2,3};
		ej.guardarCoche(matriculas, marca, year);
	}

	@Test
	void leerCochesTest() {
		Ejercicio_3_2_2 ej = new Ejercicio_3_2_2();
		ej.leerCoches();
	}
}
