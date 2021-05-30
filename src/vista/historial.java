package vista;


import java.util.ArrayList;

import modelo.Producto;
import processing.core.PApplet;
import processing.core.PImage;



public class historial extends Pantalla {
	private int pantalla = 2;
	
	public historial(PApplet app, int x, int y, int sizeX, int sizeY, PImage img, Producto producto, ArrayList<Producto> adiciones) {
		super(app, x, y, sizeX, sizeY, img);

		// TODO Auto-generated constructor stub
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
