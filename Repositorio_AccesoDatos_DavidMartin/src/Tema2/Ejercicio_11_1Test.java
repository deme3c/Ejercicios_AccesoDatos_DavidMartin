package Tema2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Ejercicio_11_1Test {

	@Test
	void modificarFinalizadaTransaccionTest() {
		Ejercicio_11_1 ej = new Ejercicio_11_1();
		ej.modificarFinalizadaTransaccion(1, false);
	}

}
