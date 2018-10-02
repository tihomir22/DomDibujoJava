package parser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class CtrlDom {

    public static Document instanciarDocument() throws ParserConfigurationException {
        Document doc = null;
        doc = (Document) DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        return doc;
    }
    public static Document instanciarDocument(File fXmlFile) throws ParserConfigurationException, SAXException, IOException {
        Document doc = null;
        doc = (Document) DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc;
    }

    public static void escriureDocumentATextXml(Document doc, File file) throws TransformerException {
        Transformer trans = TransformerFactory.newInstance().newTransformer();
        trans.setOutputProperty(OutputKeys.INDENT, "yes");

        StreamResult result = new StreamResult(file);
        DOMSource source = new DOMSource(doc);
        trans.transform(source, result);
    }

    

    public static String getValorEtiqueta(String etiqueta, Element element) {
        Node nValue = element.getElementsByTagName(etiqueta).item(0);
        return nValue.getChildNodes().item(0).getNodeValue();
    }

    public static Element getElementEtiqueta(String etiqueta,
            Element element) {
        return (Element) element.getElementsByTagName(etiqueta).item(0);
    }

}
