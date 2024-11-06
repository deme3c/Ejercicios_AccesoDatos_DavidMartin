package Tema2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio_7_1 {

    private  String url;
    private  String user;
    private  String password;
    private  String rutaCrear;
    private  String rutaRellenar;
    
    
    public void mostarDatosPorFechas(String fechaInicio, String fechaFin) {
    	leerDatos();
    	String leerDatosSQL = "SELECT * FROM ejercicio_7_1 WHERE fecha_inicio BETWEEN '" + fechaInicio + "' AND '" + fechaFin + "';";
    	Ejercicio_7_1BBDD ejbd = new Ejercicio_7_1BBDD();
    	Connection con = ejbd.abrirConexion(url, user, password);
    	ejbd.leerDatosDeLaTabla(leerDatosSQL, con);
  
    }
    
    
    public void modificarFinalizados(int[]id, boolean nueva) {
    	leerDatos();
    	String ids = "(";
    	for(int i=0; i<id.length;i++) {
    		if(id.length-1==i) {
    			ids+= id[i];
    		} else {
    			ids+= id[i] + ",";
    		}
    	}
    	ids+=");";
    	
    	String valorBoolean = String.valueOf(nueva);
    	
    	String modificarDatosSQL = "UPDATE ejercicio_7_1 SET finalizada = " + valorBoolean + " WHERE id IN "+ ids;

    	Ejercicio_7_1BBDD ejbd = new Ejercicio_7_1BBDD();
    	Connection con = ejbd.abrirConexion(url, user, password);
    	ejbd.hacerAlgoEnLaTablaConSentenciaString(modificarDatosSQL, con);
    }


    public void crearTabla() {
        leerDatos();
        String crearTablaSQL = lecturaSQL(rutaCrear);  
        Ejercicio_7_1BBDD ejbd = new Ejercicio_7_1BBDD();
        Connection con = ejbd.abrirConexion(url, user, password);
        ejbd.hacerAlgoEnLaTablaConSentenciaString(crearTablaSQL, con);
    }
    
    
    public void rellenarTabla() {
        leerDatos();
        String meterDatosSQL = lecturaSQL(rutaRellenar);  
        Ejercicio_7_1BBDD ejbd = new Ejercicio_7_1BBDD();
        Connection con = ejbd.abrirConexion(url, user, password);
        ejbd.hacerAlgoEnLaTablaConSentenciaString(meterDatosSQL, con);
    	
    }
	
	public String lecturaSQL(String ruta) {
	    String contenido = "";
	    try (BufferedReader br = new BufferedReader(new FileReader(new File(ruta)))) {
	        String linea;
	        while ((linea = br.readLine()) != null) {
	            contenido+=linea + "\n";
	        }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return contenido;
	}
    

    
	public void leerDatos() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("./bd.config")));
			String linea = "";
			while(linea!=null) {
				
                if (linea.startsWith("url=")) {
                    url = linea.substring(4);
                } else if (linea.startsWith("user=")) {
                    user = linea.substring(5);
                } else if (linea.startsWith("password=")) {
                    password = linea.substring(9);
                } else if (linea.startsWith("rutaCrear=")) {
                    rutaCrear = linea.substring(10);
                } else if (linea.startsWith("rutaRellenar=")) {
                    rutaRellenar = linea.substring(13);
                }
                
                linea = br.readLine();
                if(linea==null) {
                	break;
                }
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRutaCrear() {
		return rutaCrear;
	}

	public void setRutaCrear(String rutaCrear) {
		this.rutaCrear = rutaCrear;
	}

	public String getRutaRellenar() {
		return rutaRellenar;
	}

	public void setRutaRellenar(String rutaRellenar) {
		this.rutaRellenar = rutaRellenar;
	}


	
}
