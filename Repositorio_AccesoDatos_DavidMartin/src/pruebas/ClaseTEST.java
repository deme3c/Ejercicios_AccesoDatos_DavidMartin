package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClaseTEST{

	@Test
	void crearTablaTest() {
		ej7 ej = new ej7();
		ej.crearTabla();
		ej.close();
	}

	@Test
	void rellenarTablaTest() {
		ej7 ej = new ej7();
		ej.rellenarTabla();
		ej.close();
	}
	
	@Test
	void cambiarIDsTest() {
		ej7 ej = new ej7();
		String[]ids = {"1","2","3"};
		ej.cambiarFinalizada(ids, true);
		ej.close();
	}
	
	@Test
	void mostarDatosTest() {
		ej7 ej = new ej7();
		String fechaInicio = "2024-06-01";
		String fechaFin = "2024-10-30";
		ej.mostrarDatos(fechaInicio, fechaFin);
		ej.close();
	}
	
	@Test
	void datosTransaccionTest() {
		ej9 ej = new ej9();
		ej.datosTransaccion();
		ej.close();

	}
	
//	@Test
//	void insertarRegistrosCSVTest() {
//		ej10 ej = new ej10();
//		ej.insertarRegistrosCSV();
//		ej.close();
//	}
	
	@Test
	void modificarConProcedimientoTest() {
		ej11 ej = new ej11();
		int[]ids = {1,2,3};
		boolean nuevoEstado = true;
		ej.modificarConProcedimiento(ids, nuevoEstado);
		ej.close();
	}
	
	
}
