package Tema1;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
 * Ejercicio 5.2.1
 * A partir de un fichero con estructura XML que contenga un listado de coches, en el cual la matrícula sea considerada un atributo 
 * y los datos de marca y anio sean tratados como nodos, se implementará una clase que permita mostrar por pantalla la información 
 * del fichero.
 * 
 * Emplea un método de Test para la ejecución de todos los métodos de la clase.

 */
public class Ejercicio_5_2_1 {

	public void informacionXML() {
		
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder builder = factoria.newDocumentBuilder();
			Document doc = builder.parse("./tmp/coches.xml");
			doc.normalize();
			
			NodeList coches = doc.getElementsByTagName("coche");
			
			for(int i=0; i<coches.getLength();i++) {
				Element coche = (Element) coches.item(i);
				String matricula = coche.getAttribute("matricula");
				
				Element eMarca = (Element) coche.getElementsByTagName("marca").item(0);
				String marca = eMarca.getTextContent();
				
				Element eYear = (Element) coche.getElementsByTagName("year").item(0);
				String year = eYear.getTextContent();
				
				System.out.println("Coche: "+ i + " Matricula: "+ matricula + " Marca: "+ marca + " Año: "+ year);
			}
			
			
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
