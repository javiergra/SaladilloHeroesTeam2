package es.iessaladillo.juegos.saladillo.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import es.iessaladillo.juegos.saladillo.controller.MapaInterface;
import es.iessaladillo.juegos.saladillo.model.SaladilloFacade;
import es.iessaladillo.juegos.saladillo.model.components.Mapa;



public class CargadorNiveles {
	
	public static ArrayList<Entidad> cargarNivel(String fichero){
	
		ArrayList<Entidad> entidades = new ArrayList<Entidad>();;


		 
		    try {
		 
			File fXmlFile = new File(fichero);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
		
		 
			doc.getDocumentElement().normalize();
		 
		
		 
			NodeList nList = doc.getElementsByTagName("entity");
		 
			
		 
			for (int temp = 0; temp < nList.getLength(); temp++) {
		 
				Node nNode = nList.item(temp);
		 
		 
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		 
					Element eElement = (Element) nNode;
		 
					String type= eElement.getAttribute("type");
					String x = eElement.getAttribute("x");
					String y =  eElement.getAttribute("y");
					entidades.add(new Entidad(type,Integer.parseInt(x)/32,Integer.parseInt(y)/32));
				}
			}
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		  
		 
	return entidades;
		
	
	

	}
	
	static public void main(String args[]) throws IOException{//prueba
		
		ArrayList<Entidad> entidades = cargarNivel("src/1.lvl");
		//System.out.println(entidades);
		SaladilloFacade f = new SaladilloFacade();
		f.cargarMapa(entidades.toArray(new Entidad[entidades.size()]));
		
		MapaInterface mapa = f.getMapa();
		
		String s;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		while(true) {
			System.out.println(f.mapaToAscii(f.getMapa()));
			System.out.print(mapa.getPosicionHeroe() + " Mov: ");
			s = br.readLine();
			
			
			switch(s.charAt(0)) {
			case 'W':
			case 'w':
				f.setMapa((Mapa) f.mover(Direccion.UP));
				break;
				
			case 'A':
			case 'a':
				f.setMapa((Mapa) f.mover(Direccion.LEFT));
				break;
				
			case 'S':	
			case 's':
				f.setMapa((Mapa) f.mover(Direccion.DOWN));
				break;
				
			case 'D':
			case 'd':
				f.setMapa((Mapa) f.mover(Direccion.RIGHT));
				break;
				
			}
		}
		
	}
	
}
