/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Point;

public abstract class Figura {

    private TipusFigura tipusFigura = TipusFigura.INDETERMINADA;
    private Point posicio = null;
    private int escala = 1;
    private float rotacio = 0f;

    public Figura() {
        posicio = new Point(0, 0);
    }

    public Figura(Point p) {
        posicio = p;
    }

    public Figura(int x, int y) {
        posicio = new Point(x, y);
    }

    /**
     * @return the escala
     */
    public int getEscala() {
        return escala;
    }

    /**
     * @return the posicio
     */
    public Point getPosicio() {
        return posicio;
    }

    /**
     * @return the rotacio
     */
    public float getRotacio() {
        return rotacio;
    }

    /**
     * @param escala the escala to set
     */
    public void setEscala(int escala) {
        this.escala = escala;
    }

    /**
     * @param posicio the posicio to set
     */
    public void setPosicio(Point posicio) {
        this.posicio = posicio;
    }

    /**
     * @param posicio the posicio to set
     */
    public void setPosicio(int x, int y) {
        this.posicio.x = x;
        this.posicio.y = y;
    }

    /**
     * @param rotacio the rotacio to set
     */
    public void setRotacio(float rotacio) {
        this.rotacio = rotacio;
    }

    /**
     * @return the tipusFigura
     */
    public TipusFigura getTipusFigura() {
        return tipusFigura;
    }

    /**
     * @param tipusFigura the tipusFigura to set
     */
    protected void setTipusFigura(TipusFigura tipusFigura) {
        this.tipusFigura = tipusFigura;
    }

    @Override
    public String toString(){
    
    return this.tipusFigura.toString()+"\t"+this.getPosicio()+"\t"+this.getEscala()+"\t"+this.getRotacio();
    
    }
}
