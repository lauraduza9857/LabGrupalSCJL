package vista;


import java.util.ArrayList;


import processing.core.PApplet;
import processing.core.PImage;



public class historial extends Pantalla {
	private int pantalla = 2;
	ArrayList<Orden>c;
	
	public historial(PApplet app, int x, int y, int sizeX, int sizeY, PImage img) {		
	super(app, x, y, sizeX, sizeY, img);
		c = new ArrayList<Orden>();
	}



	@Override
	public void pintar() {
		this.app.image(img, x, y, sizeX, sizeY);


	}

	@Override
	public void click() {
		
	}
	public int getPantalla() {
		return pantalla;
	}


	public void setPantalla(int pantalla) {
		this.pantalla = pantalla;
	}

}
