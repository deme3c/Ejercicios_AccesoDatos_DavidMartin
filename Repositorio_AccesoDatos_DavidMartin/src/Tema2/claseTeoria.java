package Tema2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class claseTeoria {

	public void abrirConexion() {

		String url = "jdbc:mysql://localhost:3306/burger";
		String user = "root";
		String password = "";

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			// Establecer la conexion
			con = DriverManager.getConnection(url, user, password);

			// Crear un objeto Statement para poder realizar consultas SQL y un objeto
			// ResultSet para almacenar el resulado
			st = con.createStatement();
			st.executeQuery("SELECT * FROM hamburguesa;");
			rs = st.getResultSet();

			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				System.out.println("ID: " + id + " \nNombre: " + nombre + "\n");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// Cerrar la conexion
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public void updateTable(String sentenciaSQL) {

		String url = "jdbc:mysql://localhost:3306/burger";
		String user = "root";
		String password = "";

		Connection con = null;
		Statement st = null;

		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			st.executeUpdate(sentenciaSQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// Cerrar la conexion

			try {
				st.close();
			} catch (SQLException e) {
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
		}

	}

}
