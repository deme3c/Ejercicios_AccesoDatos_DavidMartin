package manejoobjetos3;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

public class Ejercicio_3_3_2_BBDD implements AutoCloseable{

	ODB odb = null;
	
	public Ejercicio_3_3_2_BBDD(String pathDB) {
		odb = ODBFactory.open(pathDB);
	}

	@Override
	public void close(){
		if(odb!=null) {
			odb.close();
		}
		
	}
	
	
	
}
