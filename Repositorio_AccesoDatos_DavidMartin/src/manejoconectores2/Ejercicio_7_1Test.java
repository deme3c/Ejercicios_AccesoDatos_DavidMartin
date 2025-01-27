package manejoconectores2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Ejercicio_7_1Test {

	@Test
	void crearTablaTest() {
		Ejercicio_7_1 ej = new Ejercicio_7_1();
		ej.crearTabla();
	}

	@Test
	void rellenarTablaTest() {
		Ejercicio_7_1 ej = new Ejercicio_7_1();
		ej.rellenarTabla();
	}

	@Test
	void modificarTablaTest() {
		Ejercicio_7_1 ej = new Ejercicio_7_1();
		int[]idsModificar = {1,2,3};
		ej.modificarFinalizados(idsModificar, false);
	}
	
	@Test
	void mostarDatosPorFechasTest() {
		Ejercicio_7_1 ej = new Ejercicio_7_1();
		String fechaInicio = "2024-06-01";
		String fechaFin = "2024-10-30";
		ej.mostarDatosPorFechas(fechaInicio, fechaFin);
		
	}
}
