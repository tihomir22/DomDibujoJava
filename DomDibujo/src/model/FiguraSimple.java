/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Point;

public class FiguraSimple extends Figura {

    private Color colorLinia = Color.BLACK;
    private Color colorFigura = Color.WHITE;

    public FiguraSimple() {
    }

    public FiguraSimple(Point p) {
        super(p);
    }

    public FiguraSimple(int x, int y) {
        super(x, y);
    }

    /**
     * @return the colorLinia
     */
    public Color getColorLinia() {
        return colorLinia;
    }

    /**
     * @param colorLinia the colorLinia to set
     */
    public void setColorLinia(Color colorLinia) {
        this.colorLinia = colorLinia;
    }

    /**
     * @return the colorFigura
     */
    public Color getColorFigura() {
        return colorFigura;
    }

    /**
     * @param colorFigura the colorFigura to set
     */
    public void setColorFigura(Color colorFigura) {
        this.colorFigura = colorFigura;
    }

    @Override
    public String toString() {

        return super.toString() + this.getColorFigura() + "\t" + this.getColorLinia();
    }

}
