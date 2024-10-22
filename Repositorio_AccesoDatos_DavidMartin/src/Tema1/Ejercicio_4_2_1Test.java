package Tema1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Ejercicio_4_2_1Test {

	@Test
	void insertarRegistroTest() {
		Ejercicio_4_2_1 ej = new Ejercicio_4_2_1();
		int id[] ={1,2,3};
		String nombre[]= {"Rafita","Macarena","Merche"};
		int edad[]= {19,28,32};
		ej.insertarRegistro(id, nombre, edad);
	}
	
	@Test
	void leerRegistroTest() {
		Ejercicio_4_2_1 ej = new Ejercicio_4_2_1();
		ej.LeeFicheroAleatorio();
	}

}

