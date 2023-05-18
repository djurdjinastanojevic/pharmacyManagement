package model;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class BrowserModel extends DefaultTreeModel{
	
	private static final long serialVersionUID = 1L;
	
	private static TreeNode root = new DefaultMutableTreeNode("Lanac Apoteka");
	Vector<String> neededNodes= new Vector<String>();
	
	public Vector<NodeModel> packages = new Vector<NodeModel>();
	public NodeModel newPackage = null;
	public TableModel table = null;
	public Vector<TableModel> pom = null;

	public BrowserModel() {
		super(root);
		// 
		neededNodes.add("01 Msija poslovnog sistema");
		neededNodes.add("02 Model organizacione strukture");
		neededNodes.add("03 Model resursa poslovnog sistema");
		neededNodes.add("04 Tehnologija procesa rada");
		neededNodes.add("05 Upravljačka struktura");
		neededNodes.add("06 Veze sa okruženjem");
		neededNodes.add("07 Aplikativna podrška");
				
		try {
			File xmlFile = new File("xmlfajl.xml");
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			
			NodeList packages = doc.getDocumentElement().getElementsByTagName("package");
			
			for (int i = 0; i < packages.getLength(); i++)
			{
								
				if(getNeededNodes(packages.item(i).getAttributes().getNamedItem("name").getNodeValue()))
				{
					Node node = packages.item(i);
					
					if (node.getNodeType() == Node.ELEMENT_NODE )
					{
						
						
						Element el = (Element) node;

						newPackage = new NodeModel();
		
						newPackage.setIme(getNodeName(el.getAttribute("name")));

						pom = new Vector<TableModel>();

						NodeList tabels = el.getElementsByTagName("table");
						
						
						for (int j = 0; j < tabels.getLength(); j++)
						{
							Node cvorTabela = tabels.item(j);
							Element element = (Element) cvorTabela;
							table =new TableModel();
							table.setNaziv(element.getAttribute("name"));
							pom.add(table);
							
						}
						
						newPackage.setTabele(pom);
						
						this.packages.add(newPackage);
					}
				}
			}
			
		} 
		catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		catch (SAXException e)
		{
			e.printStackTrace();
		}
		
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	//da li je osnovni paket ili ne
	@Override
	public boolean isLeaf(Object node)
	{
		if (node == getRoot())
		{
			return false;
		} 
		else
		{
			for (int i = 0; i < packages.size(); i++)
			{
				if (packages.elementAt(i) == node)
				{
					return false;
				}
			}
		}
		return true;
	}
	
	@Override
	public int getChildCount(Object parent)
	{
		if (parent == getRoot()) 
		{
			return packages.size();
		}
		for (int i = 0; i < packages.size(); i++)
		{
			if (parent == packages.elementAt(i))
			{
					return packages.elementAt(i).getTabele().size();
			}
		}
		return 0;
	}

	@Override
	public Object getChild(Object parent, int index)
	{
		for (int i = 0; i < packages.size(); i++)
		{
			if (packages.get(i) == parent)
			{
				return packages.elementAt(i).getTabele().elementAt(index);
			}
		}
			if (parent == getRoot())
			{
				return packages.elementAt(index);
			}
		return null;
	}
	
	private Boolean getNeededNodes(String nodeName) {
		
		
		
		for(int i = 0; i< neededNodes.size(); i++)
		{
			if(nodeName.contains(neededNodes.elementAt(i)))
				return true;
		}
		return false;
	}
	
	private String getNodeName(String name) {
		
		for(int i = 0; i< neededNodes.size();i++)
		{
			if(name.contains(neededNodes.get(i)))
				return neededNodes.get(i);
		}
		return "";
	}
}
