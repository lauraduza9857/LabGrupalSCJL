package vista;

import processing.core.PApplet;
import processing.core.PImage;

public class Check extends Pantalla{
	
	private int pantalla;
	
	public Check(PApplet app, int x, int y, int sizeX, int sizeY, PImage img) {
		super(app, x, y, sizeX, sizeY, img);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pintar() {
		this.app.image(img, x, y, sizeX, sizeY);
		
	}

	@Override
	public void click() {
		if (this.app.mouseX > 121 && this.app.mouseX <  251 && this.app.mouseY > 530 && this.app.mouseY < 555) {
			//pantalla = 4;
			
		}
		
	}

}
