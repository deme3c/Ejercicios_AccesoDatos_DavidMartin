package Tema2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ejercicio_8_1 {

	private static String url = "jdbc:mysql://localhost:3306/burger";
	private static String user = "root";
	private static String password = "";
	
	public int error1042() {
		Connection con = null;
		int error = 0;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/burgerWrong",user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			error = e.getErrorCode();
		} 
		return error;
		
		
	}
	
}
