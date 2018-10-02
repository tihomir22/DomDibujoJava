/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Point;
public class Rectangle extends FiguraSimple{
    private int amplada;
    private int alcada;

    public Rectangle() {
        setTipusFigura(TipusFigura.RECTANGLE);        
    }

    public Rectangle(Point p, int amplada, int alcada) {
        super(p);
        setTipusFigura(TipusFigura.RECTANGLE);        
        this.amplada = amplada;
        this.alcada = alcada;
    }
    
    public Rectangle(int x, int y, int amplada, int alcada) {
        super(x, y);
        setTipusFigura(TipusFigura.RECTANGLE);        
        this.amplada = amplada;
        this.alcada = alcada;
    }
    
  
    
    /**
     * @return the amplada
     */
    public int getAmplada() {
        return amplada;
    }

    /**
     * @param amplada the amplada to set
     */
    public void setAmplada(int amplada) {
        this.amplada = amplada;
    }

    /**
     * @return the alcada
     */
    public int getAlcada() {
        return alcada;
    }

    /**
     * @param alcada the alcada to set
     */
    public void setAlcada(int alcada) {
        this.alcada = alcada;
    }
    @Override
    public String toString(){
    
    return super.toString()+"\t"+this.getAlcada()+"\t"+this.getAmplada();
    
    }
}
