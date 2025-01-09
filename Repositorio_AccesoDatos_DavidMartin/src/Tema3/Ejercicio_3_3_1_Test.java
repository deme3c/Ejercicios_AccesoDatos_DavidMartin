package Tema3;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

class Ejercicio_3_3_1_Test {
	
	String pathBD = "./db/ejercicio_3_1_1.db";

	@Test
	void mostrarTareasDescripcionTest() {
		Ejercicio_3_3_1 ej = new Ejercicio_3_3_1(pathBD);
		ej.mostrarTareasDescripcion("Com");
	}

	@Test
	void mostrarFechasIncluidasTest() {
		Ejercicio_3_3_1 ej = new Ejercicio_3_3_1(pathBD);
		
		Date fecha1 = null;
		Date fecha2 = null;
		try {
			fecha1 = new SimpleDateFormat("yyyy-MM-dd").parse("2024-05-02");
			fecha2 = new SimpleDateFormat("yyyy-MM-dd").parse("2024-11-01");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ej.mostrarFechasIncluidas(fecha1, fecha2);

	}
	
	@Test
	void mostrarFechasExcluidasTest() {
		Ejercicio_3_3_1 ej = new Ejercicio_3_3_1(pathBD);
		
		Date fecha1 = null;
		Date fecha2 = null;
		try {
			fecha1 = new SimpleDateFormat("yyyy-MM-dd").parse("2024-05-02");
			fecha2 = new SimpleDateFormat("yyyy-MM-dd").parse("2024-11-01");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ej.mostrarFechasExcluidas(fecha1, fecha2);

	}
	
	@Test
	void modificarFinalizadaIDtest(){
		Ejercicio_3_3_1 ej = new Ejercicio_3_3_1(pathBD);
		ej.modificarFinalizadaID(7, true);
		ej.close();
	}
	
	
}
