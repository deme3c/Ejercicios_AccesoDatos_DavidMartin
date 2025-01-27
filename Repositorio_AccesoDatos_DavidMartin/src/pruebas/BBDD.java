package pruebas;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BBDD implements AutoCloseable{

	private Connection con = null;
	
	
	public BBDD (String url, String user, String passwd) {
		try {
			con = DriverManager.getConnection(url, user, passwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//EJERCICIO 11
	public void modificarTareaConcreta(int[]ids, boolean estado) {
		CallableStatement cstm = null;
		boolean autocommit = true;
		
		try {
			autocommit = con.getAutoCommit();
			con.setAutoCommit(false);
			
			for(int i=0; i<ids.length;i++) {
				cstm = con.prepareCall("{call listar_tareas2 (?,?)}");
				cstm.setInt(1, ids[i]);
				cstm.setBoolean(2, estado);
				cstm.execute();
			}
			con.commit();
			con.setAutoCommit(autocommit);
			
	
			ResultSet rs = cstm.executeQuery("SELECT * FROM ejercicio_7_1;");
			while(rs.next()) {
				int id = rs.getInt("id");
				System.out.println(id);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				if(cstm!=null && !cstm.isClosed()) {
					cstm.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	//EJERCICIO 10
	public void insertarRegistrosCSV(ArrayList<Tarea> contenido) {
		PreparedStatement pr = null;
		String sentenciaSQL = "INSERT INTO ejercicio_7_1 VALUES (?,?,?,?,?);";
		try {
			pr = con.prepareStatement(sentenciaSQL);
			for(Tarea tupla : contenido) {
				pr.setInt(1, tupla.getId());
				pr.setString(2, tupla.getDescripcion());
				pr.setString(3, tupla.getFechaInicio());
				pr.setString(4, tupla.getFechaFin());
				pr.setBoolean(5, tupla.isFinalizada());
				pr.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	// EJERCICIO 9
	public void insertarDatosTransaccion(ArrayList<String> sentencia) {
		Statement st = null;
		boolean commit = true;
		try {
			st = con.createStatement();
			commit = con.getAutoCommit();
			con.setAutoCommit(false);
			
			for(String linea : sentencia) {
				st.executeUpdate(linea);
			}
			con.commit();
			con.setAutoCommit(commit);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if(st!=null && !st.isClosed()) {
					st.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	//EJERCICIO 7
	public void ejecutarQuery(String contenido) {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			st.executeQuery(contenido);
			rs = st.getResultSet();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String descripcion = rs.getString("descripcion");
				String fecha_inicio = rs.getString("fecha_inicio");
				String fechaFin = rs.getString("fecha_fin");
				String finalizada = rs.getString("finalizada");
				
				System.out.println(id + " " + descripcion + " " + fecha_inicio + " " + fechaFin + " " + finalizada + "\n");
			}
			
		
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(st!=null && !st.isClosed()) {
					st.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//EJERCICIO 7
	public void ejecutarUpdate(String contenido) {
		Statement st = null;
		try {
			st = con.createStatement();
			st.executeUpdate(contenido);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error en el metodo ejecutarUpdate");
		} finally {
			try {
				if(st!=null && !st.isClosed()) st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	@Override
	public void close() {
		
		try {
			if (con != null && !con.isClosed()) {
				con.close();
				System.out.println("Cerrando conexión");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
