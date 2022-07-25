
package com.appium.utils;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TestUtils {


	/*  parseStringXML () : provides the basic implementation of the Map interface of Java.
	 *  It stores the data in (Key, Value) pairs of xml file, and you can access them by an index of another type
    */
	static public HashMap<String, String> parseStringXML(InputStream file) throws Exception {
		HashMap<String, String> stringMap = new HashMap<String, String>(); 	// Create an empty hash map by declaring object of string and String type

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 		// Get Document Builder

		DocumentBuilder builder = factory.newDocumentBuilder();

		Document document = builder.parse(file); // Build Document

		document.getDocumentElement().normalize(); 		// Normalize the XML Structure; It's just too important !!


		Element root = document.getDocumentElement(); 		// Here comes the root node


		NodeList nList = document.getElementsByTagName("string"); 		// Get all elements

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node node = nList.item(temp);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				stringMap.put(eElement.getAttribute("name"), eElement.getAttribute("value")); // Store each element key value in map
			}
		}
		return stringMap;
	}

	// dateTime()  : provides date Format like (yyyy-MM-dd-HH-mm-ss)
	public static String dateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	// log()  : provides Log to standard out so that the Appium framework can pick it up.
	public static Logger log() {
		return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
	}

}
