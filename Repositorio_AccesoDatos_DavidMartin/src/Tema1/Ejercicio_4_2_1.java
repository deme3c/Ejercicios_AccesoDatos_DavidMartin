package Tema1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * Ejercicio 4.2.1 
 * A partir de los ejemplos de escritura y lectura de fichero en modo aleatorio vistos anteriormente implementa una clase 
 * que permita insertar registros del mismo tipo mediante arrays pasados por parámetros con los IDs, nombres y edades de usuarios.
 * 
 * Implementa otro método que permita la lectura de todos los registros del fichero.
 * 
 * Implementa finalmente un método que modifique la edad de un registro para un id determinado pasado por parámetro. 
 * La edad también se pasará por parámetro a este nuevo método.
 * 
 * Emplea un método de Test para la ejecución de todos los métodos de la clase.

 */
public class Ejercicio_4_2_1 {

	public void insertarRegistro(int[] id, String[] nombre, int[] edad) {

		try {
			RandomAccessFile raf = new RandomAccessFile("./tmp/usuarios.dat", "rw");
			
			for (int i = 0; i < id.length; i++) {
				
				raf.writeInt(id[i]);
				
				StringBuffer sBuffer = new StringBuffer(nombre[i]);
				sBuffer.setLength(20);
				raf.writeChars(sBuffer.toString());		
				raf.writeInt(edad[i]);
			}
			raf.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void LeeFicheroAleatorio() {
		try {
			RandomAccessFile raf = new RandomAccessFile("./tmp/usuarios.dat", "r");
			
			boolean salir = false;
			long posicion = 0L;
			while (!salir) {

				try {
					LeeRegistro(raf, posicion);
					posicion += 0L + 4 + 40 + 4;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					salir = true;
				}
			} 
				
			raf.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void LeeRegistro(RandomAccessFile raf, long pos) throws IOException {
		raf.seek(pos);
		int id = raf.readInt();
		char[]nombre = new char[20];
		for (int i = 0; i < nombre.length; i++) {
			char temp = raf.readChar();
			nombre[i]=temp;
		}
		String nombreCompleto = new String(nombre).trim();
		int edad = raf.readInt();
		
		System.out.println("id: " + id + " nombre: " + nombreCompleto + " edad: " + edad);
	
	}
	
	
}
