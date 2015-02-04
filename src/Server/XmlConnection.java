package Server;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class XmlConnection {

	private static Document xmlDoc;
	private static DocumentBuilder docReader;
	private static XPath xPath;

	public XmlConnection() throws ParserConfigurationException, SAXException,
			IOException {
		docReader = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		xmlDoc = docReader.parse(new File("./XML/User.xml"));

		xPath = XPathFactory.newInstance().newXPath();

	}

	public static int userLogin(String username, String password) {
		String expression = "//user[@name =\"" + username
				+ "\" and @password=\"" + password + "\"]";
		System.out.println(expression);

		try {
			Node user = (Node) xPath.compile(expression).evaluate(xmlDoc,
					XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		return 0;

	}
	
	public static void main(String[] args) {
		try {
			XmlConnection test = new XmlConnection();
			XmlConnection.userLogin("Sanela", "Semsa");
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		
	}
}
