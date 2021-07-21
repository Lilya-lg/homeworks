package Lesson10;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class Main {
	public static void main(String[] args) throws InterruptedException, ParserConfigurationException, SAXException, IOException {
	SAXParserFactory factory = SAXParserFactory.newInstance();
	SAXParser parser = 	factory.newSAXParser();
	File file = new File("pom.xml");
	parser.parse(file, new PomParse());
	}
}
