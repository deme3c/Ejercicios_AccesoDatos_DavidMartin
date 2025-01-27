package manejoficheros1;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class Ejercicio_2_3_1Test {

	@Test
	void pruebaMetodoUno() {
		Ejercicio_2_3_1 eu = new Ejercicio_2_3_1();
		eu.metodoUno("C:\\Users\\dmart\\pruebas\\metodoUno");
	}
	@Test
	void pruebaMetodoDos() {
		Ejercicio_2_3_1 eu = new Ejercicio_2_3_1();
		eu.metodoDos("C:/Users/dmart/pruebas", "ficheroCreadoMetodo2");
	}
	
	@Test
	void pruebaMetodoTres() {
		Ejercicio_2_3_1 eu = new Ejercicio_2_3_1();
		File tres = new File("C:\\Users\\dmart\\pruebas");
		try {
			eu.metodoTres(tres, "ficheroMetodo3");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// el try catch debe estar creado siempre en algun lugar, en este caso al enviar la excepcion desde el metodo3 con throws IOexception
	}
	
	@Test
	void pruebaMetodoCuatro() {
		Ejercicio_2_3_1 eu = new Ejercicio_2_3_1();
		File cuatro = new File("C:\\Users\\dmart\\pruebas\\ficheroMetodo3.txt");
		eu.metodoCuatro(cuatro, "C:\\Users\\dmart\\pruebas\\metodoUno", "fichero6");
	}
	
	
	@Test 
	void pruebaExtension() {
		Ejercicio_2_3_1 eu = new Ejercicio_2_3_1();
		File cinco = new File("C:\\Users\\dmart\\pruebas\\ficheroMetodo3.txt");
		eu.conocerExtension(cinco);
	}

}
