package modelo;

import processing.core.PApplet;
import vista.Elemento;

import java.util.ArrayList;

public class Pizza extends Elemento {
    public int valor;
    public int id;
    ArrayList<Adition> aditions;

    public Pizza(PApplet app, int x, int y, int sizeX, int sizeY, int _id, int _valor) {
        super(app, x, y, sizeX, sizeY);
        this.valor = _valor;
        this.id = _id;
        this.aditions = new ArrayList<>();
    }

    @Override
    public void pintar() {
       //este metodo sobra por mal diseño
    }

    public void setAditions(ArrayList<Adition> aditions){
        this.aditions = aditions;
    }
}
