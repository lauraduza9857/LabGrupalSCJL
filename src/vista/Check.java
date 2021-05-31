package vista;

import java.util.ArrayList;



import processing.core.PApplet;
import processing.core.PImage;

public class Check extends Pantalla{
	

	private int pantalla = 3;
	boolean counter = false;
	private ArrayList<Orden> hist;
	
	public Check(PApplet app, int x, int y, int sizeX, int sizeY, PImage img) {
		super(app, x, y, sizeX, sizeY, img);
		// TODO Auto-generated constructor stub
		hist = new ArrayList<Orden>();
	}

	@Override
	public void pintar() {
		this.app.image(img, x, y, sizeX, sizeY);
		
	}

	@Override
	public void click() {
		
		if (this.app.mouseX > 59 && this.app.mouseX <  172 && this.app.mouseY > 568 && this.app.mouseY < 599) {
			counter= true;
			pantalla = 4;
		
			
		} 
		
		if (this.app.mouseX > 201 && this.app.mouseX <  315 && this.app.mouseY > 568 && this.app.mouseY < 599) {
			pantalla = 0;
		}
		
	}
	


	public int getPantalla() {
		return pantalla;
	}

	public void setPantalla(int pantalla) {
		this.pantalla = pantalla;
	}

	public boolean isCounter() {
		return counter;
	}

	public void setCounter(boolean counter) {
		this.counter = counter;
	}
	
}
