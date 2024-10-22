package Tema1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio_3_1_2 {
	/*
	 * Ejercicio 3.1.2 Implementa una clase con un método que evidencie la
	 * diferencia de rendimiento entre el uso de las clases FileReader y FileWriter
	 * y las clases BufferedReader y BufferedWriter. Para los cálculos de tiempo
	 * puede hacerse uso del método System.currentTimeMillis().
	 */

	public void comparacionFileAndReader() {

		long inicio = System.currentTimeMillis();
		escribirFile();
		long fin = System.currentTimeMillis();
		System.out.println("Tiempo de escritura con File: " + (fin - inicio));
		
		inicio = System.currentTimeMillis();
		escribirBuffered();
		fin = System.currentTimeMillis();
		System.out.println("Tiempo de escritura con Buffered: " + (fin - inicio));
		
		inicio = System.currentTimeMillis();
		leerFile();
		fin = System.currentTimeMillis();
		System.out.println("Tiempo de lectura con File: " + (fin - inicio));
		
		inicio = System.currentTimeMillis();
		leerBuffered();
		fin = System.currentTimeMillis();
		System.out.println("Tiempo de lectura con Buffered: " + (fin - inicio));
		
		
	}

	public void escribirFile() {
		File fichero = new File("./tmp/312File.txt");
		try {
			FileWriter fw = new FileWriter(fichero);
			for(int i=0;i<10000;i++) {
				fw.write("Thats the way it is con File");
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void escribirBuffered() {
		File fichero = new File("./tmp/312Buffered.txt");
		try {
			FileWriter fw = new FileWriter(fichero);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < 10000; i++) {
				bw.write("Thats the way it is con Buffered");
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void leerFile() {
		File fichero = new File("./tmp/312File.txt");
		try {
			FileReader fr = new FileReader(fichero);
			int i;
			while ((i = fr.read()) != -1) {
		
			}
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void leerBuffered() {
		File fichero = new File("./tmp/312Buffered.txt");
		try {
			FileReader fr = new FileReader(fichero);
			BufferedReader br = new BufferedReader(fr);
			String linea="";
			while (linea != null) {
				linea = br.readLine();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
