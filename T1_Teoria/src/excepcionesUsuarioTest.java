import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class excepcionesUsuarioTest {

	@Test

	void pruebaMetodoUno() {
		excepcionesUsuario eu = new excepcionesUsuario();
		eu.metodoUno("C:\\Users\\dmart\\pruebas\\metodoUno");
	}
	@Test
	void pruebaMetodoDos() {
		excepcionesUsuario eu = new excepcionesUsuario();
		eu.metodoDos("C:/Users/dmart/pruebas", "ficheroCreadoMetodo2");
	}
	
	@Test
	void pruebaMetodoTres() {
		excepcionesUsuario eu = new excepcionesUsuario();
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
		excepcionesUsuario eu = new excepcionesUsuario();
		File cuatro = new File("C:\\Users\\dmart\\pruebas\\ficheroMetodo3.txt");
		eu.metodoCuatro(cuatro, "C:\\Users\\dmart\\pruebas\\metodoUno", "fichero4");
	}

}
