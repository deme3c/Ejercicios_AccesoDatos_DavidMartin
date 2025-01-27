package manejoconectores2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejercicio_11_1 {

	private static String url = "jdbc:mysql://localhost:3306/accesodatos";
	private static String user = "root";
	private static String password = "";
	
	public void modificarFinalizadaTransaccion(int ids, boolean estado) {
		Connection con = null;
		CallableStatement cstm = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			cstm = con.prepareCall("{call listar_tareas2 (?,?)}");
			cstm.setInt(1, ids);
			cstm.setBoolean(2, estado);
			cstm.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
		    	if (cstm != null && !cstm.isClosed()) {
		      	cstm.close();
		    	}
		  	} catch (SQLException ex) {}
		  	try {
		    	if (con != null && !con.isClosed()) {
		      	con.close();
		    	}
		  	} catch (SQLException ex) {}
		  	System.out.println("Operación Terminada");
		}
	}
}
