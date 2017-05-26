package com.jstartpro.springfit.dataentry;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXMLFileTest {
	XmlFile xmlFile = new XmlFile();
	Document doc = xmlFile.getXmlFile("dailyEntry_2016-4-8.xml");

	@Test
	public void testGetXmlFile() {
		assertEquals("repIn:report", doc.getDocumentElement().getNodeName());
	}

	@Test
	public void testDate(){
		NodeList nList = doc.getElementsByTagName("date");
		Node nNode = nList.item(0);
		assertEquals("2016-04-08",nNode.getTextContent());
	}

}
