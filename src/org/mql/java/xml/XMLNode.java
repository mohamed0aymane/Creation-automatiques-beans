package org.mql.java.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.List;
import java.util.Vector;


public class XMLNode {
	//reference sur l'element racine
	private Node node;
	
	//creer un objet XMLNode a partir d'un Node existant
	public XMLNode(Node node) {
		super();
		this.node = node;
	}
	
	
	//charger le document xml
	public XMLNode(String source) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(source);
			node = document.getFirstChild();
			while (node.getNodeType() != Node.ELEMENT_NODE) {
				node = node.getNextSibling();
			}
				//Short
		}catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	
	//retourne tableau de noueds enfants de node
	public XMLNode[] children() {
		List<XMLNode> list = new Vector<XMLNode>();
		NodeList n1 = node.getChildNodes();
		int n = n1.getLength();
		for (int i = 0; i < n ;i++) {
			Node child = n1.item(i);
			if(child.getNodeType() == Node.ELEMENT_NODE) {
				//Ajoute chaque élément XML sous forme d’objet XMLNode dans la liste.
				list.add(new XMLNode(child));
				/*child est de type Node et ne correspond pas au type XMLNode
				En enveloppant chaque Node dans une instance de XMLNode, 
				vous bénéficiez de toutes les méthodes (comme children() et 
				child(String name)) qui sont définies dans XMLNode.*/
			}
		}
		XMLNode t[]=new XMLNode[list.size()];
		list.toArray(t);
		return t;
	}
	
	//cherche un enfant direct du noeud actuel par soon nom et retourne un objet XMLNode correspondant a cet enfant
	public XMLNode child(String name) {
		NodeList n1 = node.getChildNodes();
		int n = n1.getLength();
		for (int i = 0; i < n ;i++) {
			Node child = n1.item(i);
			if(child.getNodeName().equals(name)){
				return new XMLNode(child);
			}
		}
		return null;
	}
	
	//retourne le nom du noeud actuel
	public String getName() {
		return node.getNodeName();
	}
	
	/*Cette méthode récupère la valeur textuelle d’un nœud XML seulement si :
	  	Le nœud n’a qu’un seul enfant.
	  	Cet enfant est un nœud de type TEXT_NODE (c'est-à-dire du texte pur).*/
	public String getValue() {
		NodeList list = node.getChildNodes();
		if(list.getLength() == 1 && list.item(0).getNodeType() == Node.TEXT_NODE) {
			return list.item(0).getNodeValue();			
		}
		return null;
	}
	
	//recupere la valeur d'un attribut specifie
	public String attribute(String name) {
		//NamedNodeMap permet d’accéder aux attributs par leur nom
		NamedNodeMap atts=node.getAttributes();
		return atts.getNamedItem(name) !=null? atts.getNamedItem(name).getNodeValue():null;
	}
	
	//recupere la valeur d'un attribut specifie sous forme d'un entier
	public int intAttribute(String name) {
		String att=attribute(name);
		try {
				return Integer.parseInt(att);
		}catch (Exception e) {
			return -1;
		}
	}
}