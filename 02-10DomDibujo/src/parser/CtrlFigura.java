package parser;

import java.awt.Color;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import model.*;

public class CtrlFigura extends CtrlDom {

    //Constants amb els noms de les etiquetes
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

    public static Figura llegir(Element element) {
        Figura res = null;
        if (element.getTagName().equalsIgnoreCase(ET_CERCLE)) {

            res = llegirCercle(element);
        } else if (element.getTagName().equalsIgnoreCase(ET_RECTANGLE)) {

            res = llegirRectangle(element);
        }
        return res;
    }

    public static Cercle llegirCercle(Element element) {
        Cercle c = new Cercle();
        Element elemFS = getElementEtiqueta(ET_FIGURA_SIMPLE, element);
        llegirFiguraSimple(elemFS, c);
        int valorI = Integer.parseInt(getValorEtiqueta(ET_RADI, element));
        c.setRadi(valorI);
        return c;
    }

    public static Rectangle llegirRectangle(Element element) {
        Rectangle r = new Rectangle();
        Element elemFS = getElementEtiqueta(ET_FIGURA_SIMPLE, element);
        llegirFiguraSimple(elemFS, r);
        int valorI = Integer.parseInt(getValorEtiqueta(ET_ALCADA, element));
        r.setAlcada(valorI);
        valorI = Integer.parseInt(getValorEtiqueta(ET_AMPLADA, element));
        r.setAmplada(valorI);
        return r;
    }

    protected static void llegirFiguraSimple(Element elemFiguraSimple, FiguraSimple fs) {
        Element elemFigura = getElementEtiqueta(ET_FIGURA, elemFiguraSimple);
        llegirFigura(elemFigura, fs);
        int valorI = Integer.parseInt(getValorEtiqueta(ET_COLOR_LIN, elemFiguraSimple));
        fs.setColorLinia(new Color(valorI));
        valorI = Integer.parseInt(getValorEtiqueta(ET_COLOR_FIG, elemFiguraSimple));
        fs.setColorFigura(new Color(valorI));
    }

    protected static void llegirFigura(Element elemFigura, Figura figura) {
        int x = Integer.parseInt(getValorEtiqueta(ET_X, elemFigura));
        int y = Integer.parseInt(getValorEtiqueta(ET_Y, elemFigura));
        figura.setPosicio(x, y);
        int valorI = Integer.parseInt(getValorEtiqueta(ET_ESCALA, elemFigura));
        figura.setEscala(valorI);
        float valorF = Float.parseFloat(getValorEtiqueta(ET_ROTACIO, elemFigura));
        figura.setRotacio(valorF);
    }

    protected static void escriureFigura(Figura figura, Element elemFigura, Document doc) {
        Element elmPosicio = doc.createElement(ET_POSICIO);
        Element nouElement = doc.createElement(ET_X);
        elmPosicio.appendChild(nouElement);
        nouElement.appendChild(doc.createTextNode(String.valueOf(figura.getPosicio().x)));
        nouElement = doc.createElement(ET_Y);
        elmPosicio.appendChild(nouElement);
        nouElement.appendChild(doc.createTextNode(String.valueOf(figura.getPosicio().y)));
        elemFigura.appendChild(elmPosicio);
        nouElement = doc.createElement(ET_ESCALA);
        nouElement.appendChild(doc.createTextNode(String.valueOf(figura.getEscala())));
        elemFigura.appendChild(nouElement);
        nouElement = doc.createElement(ET_ROTACIO);
        nouElement.appendChild(doc.createTextNode(String.valueOf(figura.getRotacio())));
        elemFigura.appendChild(nouElement);
    }

    protected static void escriureFiguraSimple(FiguraSimple fs, Element elementFS, Document doc) {

        Element elemFigura = doc.createElement(ET_FIGURA);
        escriureFigura(fs, elemFigura, doc);
        elementFS.appendChild(elemFigura);
        Element nouElement = doc.createElement(ET_COLOR_LIN);
        nouElement.appendChild(doc.createTextNode(String.valueOf(fs.getColorLinia().getRGB())));
        elementFS.appendChild(nouElement);
        nouElement = doc.createElement(ET_COLOR_FIG);
        nouElement.appendChild(doc.createTextNode(String.valueOf(fs.getColorFigura().getRGB())));
        elementFS.appendChild(nouElement);
    }

    public static void escriure(Cercle c, Element cercleElem, Document doc) {
        Element elemFiguraSimple = doc.createElement(ET_FIGURA_SIMPLE);
        escriureFiguraSimple(c, elemFiguraSimple, doc);
        cercleElem.appendChild(elemFiguraSimple);
        Element nouElement = doc.createElement(ET_RADI);
        nouElement.appendChild(doc.createTextNode(String.valueOf(c.getRadi())));
        cercleElem.appendChild(nouElement);
    }

    public static void escriure(Rectangle r, Element rectangleElem, Document doc) {
        Element elemFiguraSimple = doc.createElement(ET_FIGURA_SIMPLE);
        escriureFiguraSimple(r, elemFiguraSimple, doc);
        rectangleElem.appendChild(elemFiguraSimple);
        Element nouElement = doc.createElement(ET_ALCADA);
        nouElement.appendChild(doc.createTextNode(String.valueOf(r.getAlcada())));
        rectangleElem.appendChild(nouElement);
        nouElement = doc.createElement(ET_AMPLADA);
        nouElement.appendChild(doc.createTextNode(String.valueOf(r.getAmplada())));
        rectangleElem.appendChild(nouElement);
    }

    public static void escriure(Figura figura, Element arrel, Document doc) {
        Element elemFigura;
        TipusFigura tipusFigura = figura.getTipusFigura();
        if (tipusFigura == TipusFigura.CERCLE) {
            elemFigura = doc.createElement(ET_CERCLE);
            escriure((Cercle) figura, elemFigura, doc);
            arrel.appendChild(elemFigura);
        } else if (tipusFigura == TipusFigura.RECTANGLE) {
            elemFigura = doc.createElement(ET_RECTANGLE);
            escriure((Rectangle) figura, elemFigura, doc);
            arrel.appendChild(elemFigura);
        }
    }

}
