package vista;



import java.util.LinkedList;

import processing.core.PApplet;
import processing.core.PImage;



public class historial extends Pantalla {
	private int pantalla = 2;
	private LinkedList<histo> hist;

	
	public historial(PApplet app, int x, int y, int sizeX, int sizeY, PImage img) {		
	super(app, x, y, sizeX, sizeY, img);
	hist = new LinkedList<histo>();
	}



	@Override
	public void pintar() {
		this.app.image(img, x, y, sizeX, sizeY);
		for (int i = 0; i < LinkedList.size(); i++) {
			
		}


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
