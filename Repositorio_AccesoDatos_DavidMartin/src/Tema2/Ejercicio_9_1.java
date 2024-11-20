package Tema2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio_9_1 {

	private static String url = "jdbc:mysql://localhost:3306/accesodatos";
	private static String user = "root";
	private static String password = "";
	
	
	
	public void gestionaTransacciones() {

		String[] sentenciasSQL = new String[] {
				"INSERT INTO Ejercicio_7_1 VALUES (1, 'Comprar manzanas', '2024-02-15', '2024-02-16', true);",
				"INSERT INTO Ejercicio_7_1 VALUES (2, 'Estudiar examen', '2024-05-02', '2024-05-18', true);",
				"INSERT INTO Ejercicio_7_1 VALUES (3, 'Comprar billete para Sidney', '2024-02-15', '2024-05-20', true);",
				"INSERT INTO Ejercicio_7_1 VALUES (4, 'Ir a Australia', '2024-06-01', '2024-08-25', true)",
				"INSERT INTO Ejercicio_7_1 VALUES (5, 'Revisión del coche', '2024-10-08', '2024-10-16', true)",
				"INSERT INTO Ejercicio_7_1 VALUES (6, 'Otra cosa', '2024-10-01', '2024-12-01', false)",
				"INSERT INTO Ejercicio_7_1 VALUES (7, 'Práctica JDBC', '2024-10-30', '2024-11-07', false)",
				"INSERT INTO Ejercicio_7_1 VALUES (8, 'FCT', '2025-03-01', '2025-05-24', false)" };

		try {
			ejecuta(sentenciasSQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void ejecuta(String[] sentenciasSQL) throws SQLException {
		boolean autocommit = true;
		Statement stm = null;
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			autocommit = con.getAutoCommit();
			con.setAutoCommit(false);
			stm = con.createStatement();

			for (String str : sentenciasSQL) {
				stm.executeUpdate(str);
			}
			con.commit();
			con.setAutoCommit(autocommit);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			con.rollback();
			throw e;
		} finally {
			try {
				if (stm != null && !stm.isClosed()) {
					stm.close();
				}
				if (con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException ex) {
			}
			System.out.println("Operación Terminada");

		}
	}

}
