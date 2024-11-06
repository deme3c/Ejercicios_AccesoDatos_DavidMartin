package Tema2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio_7_1BBDD {

	public Connection abrirConexion(String url, String user, String password) {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public void hacerAlgoEnLaTablaConSentenciaString(String sentencia, Connection con) {
		Statement st = null;
		try {
			st = con.createStatement();
			st.executeUpdate(sentencia);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void leerDatosDeLaTabla(String sentencia, Connection con) {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			st.executeQuery(sentencia);
			rs = st.getResultSet();
			
			System.out.println("id - descripcion - fecha_inicio - fecha_fin - finalizada\n");
			while (rs.next()) {
				int id = rs.getInt("id");
				String descripcion = rs.getString("descripcion");
				String fechaInicio = rs.getString("fecha_inicio");
				String fechaFin = rs.getString("fecha_fin");
				String finalizada = rs.getString("finalizada");
				System.out.println(id + " " + descripcion + " " + fechaInicio + " " + fechaFin + " " + finalizada + "\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				st.close();
				rs.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
