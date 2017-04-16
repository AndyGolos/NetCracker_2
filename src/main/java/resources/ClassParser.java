package resources;

import java.io.File;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import actions.Action;

public class ClassParser {

	public static Map<String, Action> parseXML(String rootPath) {
		MappingHandler mappingHandler = null;
		Map<String, Action> classHandler = null;
		try {
			File inputFile = new File(rootPath + "/resources/pages.xml");
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			mappingHandler = new MappingHandler();
			saxParser.parse(inputFile, mappingHandler);
			classHandler = mappingHandler.bridge(mappingHandler.getClassUrls(), mappingHandler.getClassNames());
		} catch (Exception e) {
			// TODO Logger
			System.err.println(e);
		}
		return classHandler;
	}
}
