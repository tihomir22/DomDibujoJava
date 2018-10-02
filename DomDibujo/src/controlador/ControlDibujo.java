/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import model.Dibuix;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author mati
 */
public class ControlDibujo extends ControlDom{ //Extends para declararse hijo 
    
    static final String ET_DIBUIX="dibuix";
    File file=null;
    Dibuix dibujo=null;
    
    public ControlDibujo(){
        dibujo=new Dibuix();
    }
    public ControlDibujo(Dibuix dibujo){
        this.dibujo=dibujo;
    }
    public ControlDibujo(Dibuix dibujo,File file){
        this.dibujo=dibujo;
        this.file=file;
    }
    
    public void recuperar() throws ParserConfigurationException, SAXException, IOException{
        Document doc=null;
        doc=this.deXMLaDOM(file);
    }
    public Document recuperar(File xmlFile) throws ParserConfigurationException, SAXException, IOException{
        Document doc=null;
        doc=deXMLaDOM(xmlFile);
        return doc;
    }
    
    public Dibuix leerDibujo(Document doc){
        Element eDibujo=doc.getDocumentElement(); // tenemos el padre de todos los nodos
        NodeList listaFiguras=eDibujo.getChildNodes(); // Ahora tenemos las figuras (circulo y rectangulo) y si hacemos un bucle solo nos impriminiria esos
        for (int i = 0; i < listaFiguras.getLength(); i++) {
            if(listaFiguras.item(i).getNodeType()==Node.ELEMENT_NODE){
                this.dibujo.add(ControlFigura.leer((Element)listaFiguras.item(i)));
            }
        }
        return this.dibujo;
        
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Dibuix getDibujo() {
        return dibujo;
    }

    public void setDibujo(Dibuix dibujo) {
        this.dibujo = dibujo;
    }
    
    
    
    
}
