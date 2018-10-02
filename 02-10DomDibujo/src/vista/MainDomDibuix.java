/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import model.Cercle;
import model.Dibuix;
import model.Figura;
import model.Rectangle;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import parser.CtrlDibuix;
import parser.CtrlDom;

/**
 *
 * @author usuario
 */
public class MainDomDibuix {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {

        String nomFichXml1 = "dibuix1.xml";
        File f1 = new File(nomFichXml1);
        String nomFichXml2 = "dibuix2.xml";
        File f2 = new File(nomFichXml2);

        //CREO DOM con estructura del xml
        

        //LEO  la estructura del DOM Y CREO el OBJETO dibuix
        

        //Muestro OBJETO dibuix por pantalla
        System.out.println(dibuix1);
        
        // creo un OBJETO dibu2 con un rectangulo y un ci­rculo
        

        //Creo otro DOM esta vez vacio
        

        //ESCRIBO en el DOM el OBJETO dibu2
        

        //Muestro fichero por pantalla
        muestraFichero(f2);

    }

    
    static void muestraFichero(File archivo) {

        FileReader fr = null;
        BufferedReader br = null;

        try {

            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}
