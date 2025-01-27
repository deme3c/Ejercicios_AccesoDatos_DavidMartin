package manejoobjetos3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Ejercicio_3_3_2_Test {

	String pathBD = "./db/ejercicio_3_1_1.db";
	
	@Test
	void agregarTareas() {
		Ejercicio_3_3_2 ej = new Ejercicio_3_3_2(pathBD);
		
        TipoTarea tipo1 = new TipoTarea(1, "CMP", "Compra");
		
        ej.nuevaTarea(1, "Comprar manzanas", "2024-02-15", "2024-02-16", true, tipo1);
        ej.nuevaTarea(9, "Estudiar examen", "2024-05-02", "2024-05-18", true, tipo1);
        
        ej.close();
	}

}
