/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import model.*;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import parser.CtrlDom;
import parser.CtrlFigura;

/**
 *
 
 */
public class CtrlDibuix extends CtrlDom {

    static final String ET_DIBUIX = "dibuix";
    File file = null;
    private Dibuix dibuix = null;

    public CtrlDibuix() {
        dibuix = new Dibuix();
    }

    public CtrlDibuix(Dibuix dibuix) {
        this.dibuix = dibuix;
    }

    public CtrlDibuix(Dibuix dibuix, File file) {
        this.file = file;
        this.dibuix = dibuix;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    /**
     * @return the dibuix
     */
    public Dibuix getDibuix() {
        return dibuix;
    }

    public void escriure(Document doc) {
        Element arrel = doc.createElement(ET_DIBUIX);
        doc.appendChild(arrel);
        for (Figura f : dibuix) {
            CtrlFigura.escriure(f, arrel, doc);
        }
    }

    public Dibuix llegir(Document doc) {
        Element arrel = doc.getDocumentElement();

        NodeList nList = arrel.getChildNodes();
        dibuix.clear();

        for (int i = 0; i < nList.getLength(); i++) {
            if (nList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                dibuix.add(CtrlFigura.llegir((Element) nList.item(i)));
            }
        }
        return dibuix;
    }

    public void emmagetzemar() throws ParserConfigurationException, TransformerException {
        Document doc = null;
        doc = instanciarDocument();
        escriure(doc);
        escriureDocumentATextXml(doc, file);
    }

    public void emmagetzemar(Document doc, File file) throws TransformerException {
        escriureDocumentATextXml(doc, file);
    }
    public void recuperar() throws ParserConfigurationException, SAXException, IOException {

        Document doc = null;
        doc = instanciarDocument(file);
        llegir(doc);
    }

    public Document recuperar(File xmlFile) throws ParserConfigurationException, SAXException, IOException {

        Document doc = null;
        doc = instanciarDocument(xmlFile);
        return doc;

    }
}

