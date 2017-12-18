package resources;

import actions.Action;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.Map;

public class ClassParser {

	public static Map<String, Action> parseXML(String rootPath) {
		MappingHandler mappingHandler;
		Map<String, Action> classHandler = null;
		try {
			File inputFile = new File(rootPath + "/resources/pages.xml");
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			mappingHandler = new MappingHandler();
			saxParser.parse(inputFile, mappingHandler);
			classHandler = mappingHandler.bridge(mappingHandler.getClassUrls(), mappingHandler.getClassNames());
		} catch (Exception e) {
			System.err.println();
		}
		return classHandler;
	}
}
