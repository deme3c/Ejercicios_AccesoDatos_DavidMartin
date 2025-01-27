package manejoficheros1;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.Serializable;


import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.dom.DOMSource;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

/*
 * Ejercicio 5.3.1 
 * 
 * A partir del fichero de salida obtenido como resultado del Ejercicio 3.2.2, implementa una clase con un método que 
 * recupere la información y la escriba en un fichero con formato XML.
 *
 * Implementa en la clase un segundo método que a partir del resultado XML anterior lo vuelva a leer para incrementar 
 * en uno el año de matriculación de todos los coches registrados.
 * 
 * Emplea un método de Test para la ejecución de todos los métodos de la clase.
 */
public class Ejercicio_5_3_1 {

	public void escribirXML(File fichero) {

		boolean salir = false;
		
		try {
			FileInputStream fis = new FileInputStream(fichero);
			DataInputStream dis = new DataInputStream(fis);

			DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
			try {
				DocumentBuilder builder = factoria.newDocumentBuilder();
				DOMImplementation dImp = builder.getDOMImplementation();
				Document doc = dImp.createDocument(null, "coches", null);
				doc.setXmlVersion("1.0");

				int vueltas = 0;
				
				while (!salir) {
					String matriculaC = dis.readUTF();
					String marcaC = dis.readUTF();
					int anyoMatriculacion = dis.readInt();
					String yearC = "" + anyoMatriculacion;

					Element coche = doc.createElement("coche");
					doc.getDocumentElement().appendChild(coche);
					coche.setAttribute("matricula", matriculaC);

					Element marca = doc.createElement("marca");
					Text valorMarca = doc.createTextNode(marcaC);
					marca.appendChild(valorMarca);
					coche.appendChild(marca);

					Element year = doc.createElement("anyoMatriculacion");
					Text valorYear = doc.createTextNode(yearC);
					year.appendChild(valorYear);
					coche.appendChild(year);

	

					TransformerFactory factoriaT = TransformerFactory.newDefaultInstance();
					Transformer transformador = factoriaT.newTransformer();
					
					
					Source s = new DOMSource(doc);
					Result r = new StreamResult("./tmp/coches_out.xml");
					transformador.transform(s, r);

					System.out.println(vueltas);
					vueltas++;
				}

			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EOFException e) {
				// TODO Auto-generated catch block
				salir = true;
			}

			dis.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		System.out.println("TERMINADO, TODO OK");

	}
	
	
	public void incrementarYear() {
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factoria.newDocumentBuilder();
			Document doc = builder.parse("./tmp/coches_out.xml");
			doc.normalize();
			
			NodeList coches = doc.getElementsByTagName("coche");
			for(int i=0;i<coches.getLength();i++) {
				Element coche = (Element)coches.item(i);
				Element eYear = (Element)coche.getElementsByTagName("anyoMatriculacion").item(0);
				
				String textoYear = eYear.getTextContent();
				int intYear = Integer.parseInt(textoYear);
				intYear+=1;
				String textoFinalYear = ""+intYear;
				eYear.setTextContent(textoFinalYear);
			}
			
			TransformerFactory factoriaT = TransformerFactory.newDefaultInstance();
			Transformer transformador = factoriaT.newTransformer();
			Source s = new DOMSource(doc);
			Result r = new StreamResult("./tmp/coches_out.xml");
			transformador.transform(s, r);
			
			
			
			
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}



