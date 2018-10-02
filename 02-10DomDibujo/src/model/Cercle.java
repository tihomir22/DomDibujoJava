/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Point;
public class Cercle extends FiguraSimple{
    private int radi=0;

    public Cercle() {
        setTipusFigura(TipusFigura.CERCLE);
    }

    public Cercle(Point p, int radi) {
        super(p);
        setTipusFigura(TipusFigura.CERCLE);
        this.radi = radi;
    }

    public Cercle(int x, int y, int radi) {
        super(x, y);
        setTipusFigura(TipusFigura.CERCLE);
        this.radi = radi;
    }

    /**
     * @return the radi
     */
    public int getRadi() {
        return radi;
    }

    /**
     * @param radi the radi to set
     */
    public void setRadi(int radi) {
        this.radi = radi;
    }
    @Override
    public String toString(){
    
    return super.toString()+"\t"+this.getRadi();
    
    }
    
}
