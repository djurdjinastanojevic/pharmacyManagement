package parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import model.TableModel;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class ReadXMLFile {
	
	Node trazenaTabela = null;
	TableModel tabela = null;
	public ReadXMLFile(String nazivTabele) 
	{
		if(nazivTabele==null)
			return;
		try
			{
			File xmlDoc = new File("xmlfajl.xml");
			DocumentBuilderFactory dbFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuild = dbFact.newDocumentBuilder();
			Document doc = dBuild.parse(xmlDoc);
			
			NodeList table = doc.getDocumentElement().getElementsByTagName("table");
			
			for (int i = 0; i < table.getLength(); i++) {
				if(nazivTabele.contains(table.item(i).getAttributes().getNamedItem("name").getNodeValue()))
					trazenaTabela = table.item(i);	
			}
				
				if(trazenaTabela.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) trazenaTabela;
					
					tabela = new TableModel();
					
					tabela.setNaziv(eElement.getAttribute("name"));
					tabela.setKod(eElement.getAttribute("code"));
					
					Vector<String> pomocna = new Vector<String>();
					NodeList kolone = eElement.getElementsByTagName("column");
					
					for (int j = 0; j < kolone.getLength(); j++)
					{
						Node cvorKolona = kolone.item(j);
						Element element = (Element) cvorKolona;
						pomocna.add(element.getAttribute("name"));
					}
					tabela.setKolone(pomocna);	
					tabela.setBrojKolona(pomocna.size());
				}
			
			
			}
		catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getTableCode() {
	return tabela.getKod();
	}
	
	public Vector<String> getColumnName() {
		return tabela.getKolone();
	}
	public int getColumnCount()
	{
		return tabela.getBrojKolona();
	}
	
	
}
	

