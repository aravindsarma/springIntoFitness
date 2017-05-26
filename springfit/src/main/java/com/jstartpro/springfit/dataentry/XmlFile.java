package com.jstartpro.springfit.dataentry;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class XmlFile {

	public Document getXmlFile(String filePath) {
		try {
			File fXmlFile = new File(filePath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			// optional, but recommended
			return doc;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
