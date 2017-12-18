package resources;

import actions.Action;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MappingHandler extends DefaultHandler {

	private List<String> classUrls;
	private List<String> classNames;
	private String thisElement = "";

    MappingHandler() {
        classUrls = new LinkedList<>();
        classNames = new LinkedList<>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		thisElement = qName;
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		thisElement = "";
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		if (thisElement.equals("class-name")) {
			classNames.add((new String(ch, start, length)));
		}
		if (thisElement.equals("class-url")) {
			classUrls.add((new String(ch, start, length)));
		}
	}

    Map<String, Action> bridge(List<String> classUrls, List<String> classNames)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Map<String, Action> classHandler = new HashMap<>();
		for (int i = 0; i < classNames.size(); i++) {
			classHandler.put(classUrls.get(i), (Action) Class.forName(classNames.get(i)).newInstance());
		}
		return classHandler;
	}

    List<String> getClassUrls() {
        return classUrls;
    }

	public void setClassUrls(List<String> classUrls) {
		this.classUrls = classUrls;
	}

    List<String> getClassNames() {
        return classNames;
    }

	public void setClassNames(List<String> classNames) {
		this.classNames = classNames;
	}

}
