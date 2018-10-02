/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControlDibujo;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import model.Dibuix;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author mati
 */
public class DomDibujo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, SAXException, IOException, IOException, IOException {
      String nomFichXml="dibuix1.xml";
      File fi=new File(nomFichXml);
      
      //Crear arbol de nodos a partir del xml
      Document doc=null;
      ControlDibujo cdibujo=new ControlDibujo();
      doc=cdibujo.recuperar(fi);
      
      Dibuix dibujo=null;
      dibujo=cdibujo.leerDibujo(doc);
        System.out.println(dibujo.toString());
      
    }
    
}
