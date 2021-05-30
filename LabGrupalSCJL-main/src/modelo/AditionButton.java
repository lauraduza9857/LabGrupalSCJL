package modelo;

import processing.core.PApplet;
import vista.Elemento;

public class AditionButton extends Elemento {
    String contenido;
    boolean operator;
    Adition adition;
    public AditionButton(PApplet app,
                         int x,
                         int y,
                         int sizeX,
                         int sizeY,
                         String contenindo,
                         Adition adition,
                         boolean operator) {
        super(app, x, y, sizeX, sizeY);
        this.contenido = contenindo;
        this.operator = operator;
        this.adition = adition;
    }

    @Override
    public void pintar() {
        this.app.noStroke();
        this.app.fill(255);
        this.app.rect(x, y, sizeX, sizeY);
        this.app.fill(0);
        this.app.text(contenido, x+sizeX/2, y+sizeY/2);
    }

    public void operateAdition() {
        if(operator) adition.cantidad += 1;
        else if(adition.cantidad <= 0) {
        }
        else adition.cantidad -= 1;
    }
}
