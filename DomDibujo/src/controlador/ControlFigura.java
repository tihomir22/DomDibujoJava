/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.awt.Point;
import model.Cercle;
import model.Figura;
import model.FiguraSimple;
import model.Rectangle;
import org.w3c.dom.Element;

/**
 *
 * @author mati
 */
public class ControlFigura extends ControlDom {
    static final String ET_POSICIO = "posicio";
    static final String ET_X = "x";
    static final String ET_Y = "y";
    static final String ET_ESCALA = "escala";
    static final String ET_ROTACIO = "rotacio";
    static final String ET_FIGURA = "figura";
    static final String ET_COLOR_LIN = "colorlinia";
    static final String ET_COLOR_FIG = "colorfigura";
    static final String ET_FIGURA_SIMPLE = "figurasimple";
    static final String ET_ALCADA = "alcada";
    static final String ET_AMPLADA = "amplada";
    static final String ET_RECTANGLE = "rectangle";
    static final String ET_GRUP = "grup";
    static final String ET_COLLECCIO = "colleccio";
    static final String ET_CERCLE = "cercle";
    static final String ET_RADI = "radi";
    
    
    public static Figura leer(Element element){
        Figura res=null;
        if(element.getTagName().equalsIgnoreCase(ET_CERCLE)){
            res=leerCirculo(element);
        }else if(element.getTagName().equalsIgnoreCase(ET_RECTANGLE)){
            res=leerRectangulo(element);
        }
        return res;
    }
    public static Cercle leerCirculo(Element cercle){
        Cercle c=new Cercle();
        Element elementFS=getElementEtiqueta(ET_FIGURA_SIMPLE,cercle);
        leerFiguraSimple(elementFS,c);
        int radio=Integer.parseInt(getValorEtiqueta(ET_RADI,cercle));
        c.setRadi(radio);
        return c;
    }
    
    public static Rectangle leerRectangulo(Element rectangle){
        Rectangle r=new Rectangle();
        Element elementFS=getElementEtiqueta(ET_FIGURA_SIMPLE,rectangle);
        leerFiguraSimple(elementFS,r);
        int alcada=Integer.parseInt(getValorEtiqueta(ET_ALCADA,rectangle));
        r.setAlcada(alcada);
        int amplada=Integer.parseInt(getValorEtiqueta(ET_AMPLADA,rectangle));
        r.setAmplada(amplada);
        
        return r;
    }

    public static void leerFiguraSimple(Element elementFS, FiguraSimple fs) {
       Element elemFigura=getElementEtiqueta(ET_FIGURA,elementFS);
       leerFigura(elementFS,fs);
       int colorLin=Integer.parseInt(getValorEtiqueta(ET_COLOR_LIN,elementFS));
       fs.setColorLinia(new Color(colorLin));
       int colorFig=Integer.parseInt(getValorEtiqueta(ET_COLOR_FIG,elementFS));
       fs.setColorFigura(new Color(colorFig));
    }

    public static void leerFigura(Element elementFigura, Figura fs) {
         Element ePosicion=getElementEtiqueta(ET_POSICIO,elementFigura);
         int x=Integer.parseInt(getValorEtiqueta(ET_X,ePosicion));
         int y=Integer.parseInt(getValorEtiqueta(ET_Y,ePosicion));
         Point p=new Point(x,y);
         int escala=Integer.parseInt(getValorEtiqueta(ET_ESCALA,elementFigura));
         float rotacio=Float.parseFloat(getValorEtiqueta(ET_ROTACIO,elementFigura));
         fs.setPosicio(p);
         fs.setEscala(escala);
         fs.setRotacio(rotacio);
    }
    
    
    
}
