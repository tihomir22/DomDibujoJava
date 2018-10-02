/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

public class Dibuix extends ArrayList<Figura> {

    public ArrayList<Figura> getFigures() {
        return this;
    }

    public void copiarDesDe(Dibuix dibuix) {
        this.clear();
        this.addAll(dibuix);
    }

    public void up(int pos) {
        if (pos <= 0) {
            return;
        }
        Figura fig = this.get(pos);
        this.set(pos, this.get(pos - 1));
        this.set(pos - 1, fig);
    }

    public void down(int pos) {
        if (pos == size() - 1) {
            return;
        }
        Figura fig = this.get(pos);
        this.set(pos, this.get(pos + 1));
        this.set(pos + 1, fig);
    }

    @Override
    public String toString() {
        String result = "+";
        for (int i = 0; i < this.getFigures().size(); i++) {

            result += "\n" + this.getFigures().get(i).toString();
        }
        
        return result;

    }
}
