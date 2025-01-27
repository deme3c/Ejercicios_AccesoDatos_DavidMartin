package pruebas;

import org.junit.jupiter.api.Test;

class claseTeoriaTest {

	@Test
	void abrirConexionTest() {
		claseTeoria clase = new claseTeoria();
		clase.abrirConexion();
	}
	@Test
	void crearTablaTest() {
		claseTeoria clase = new claseTeoria();
		String sentenciaSQL = """
			    CREATE TABLE pizzas (
		        id INT,
		        nombre VARCHAR(50),
		        precio DOUBLE,
		        CONSTRAINT pk_id PRIMARY KEY (id)
		    );
		    """;
	
		clase.updateTable(sentenciaSQL);
	}
	@Test
	void borrarTablaTest() {
		claseTeoria clase = new claseTeoria();
		String sentenciaSQL = "DROP TABLE pizzas;";
		clase.updateTable(sentenciaSQL);
	}
}
