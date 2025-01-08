package Tema3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Ejercicio_3_1_1Test {

	@Test
	void crearInsertarTareas_Test() {
		Ejercicio_3_1_1 ej = new Ejercicio_3_1_1();
		ej.crearInsertarTareas();
		ej.close();
	}

	@Test
	void mostrarTareaMedianteID_Test() {
		Ejercicio_3_1_1 ej = new Ejercicio_3_1_1();
		ej.mostrarTareaMedianteID(5);
		ej.close();
	}
	
	@Test
	void mostrarTipoTareasEnLaBBDD() {
		Ejercicio_3_1_1 ej = new Ejercicio_3_1_1();
		ej.mostrarTipoTareas();
		ej.close();
	}
	
	@Test
	void mostrarTareasEnLaBBDD() {
		Ejercicio_3_1_1 ej = new Ejercicio_3_1_1();
		ej.mostrarTareasEnLaBBDD();
		ej.close();
	}
	

	
}
