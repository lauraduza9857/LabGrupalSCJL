package vista;

import processing.core.PApplet;
import processing.core.PImage;

public class Login extends Pantalla{

	public Login(PApplet app, int x, int y, int sizeX, int sizeY, PImage img) {
		super(app, x, y, sizeX, sizeY, img);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pintar() {
		this.app.image(img, x, y, sizeX, sizeY);
		
	}

	@Override
	public void click() {
		// TODO Auto-generated method stub
		
	}

}
