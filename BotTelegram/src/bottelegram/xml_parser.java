/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bottelegram;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Stefano Potenza
 */
public class xml_parser {
    public xml_parser() {
    }

    public String DocumentParse(String path, String elementName) throws ParserConfigurationException, SAXException, IOException {

        String csv = "";
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Node root, element;
        NodeList nodeList;
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        Document document = builder.parse(path);
        root = document.getDocumentElement();
        nodeList = document.getElementsByTagName("Success");
        if (nodeList.getLength() > 0) {
            Node n = nodeList.item(0);
            csv += n.getTextContent();
            csv += ";";
            Node sibiling = n.getNextSibling();
            if (sibiling != null) {
                csv += sibiling.getTextContent();
            }
        } else {
            nodeList = document.getElementsByTagName(elementName);
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element e = (Element) nodeList.item(i);
                if (e.hasChildNodes()) {
                    if (e.hasAttribute("id")) {
                        csv += e.getAttribute("id");
                        csv += ";";
                    }
                    Node child = e.getFirstChild();
                    for (int j = 0; child != null; j++) {
                        csv += child.getTextContent();
                        csv += ";";
                        child = child.getNextSibling();
                    }
                    csv += "<>";
                }
            }
        }
        return csv;
    }
}
