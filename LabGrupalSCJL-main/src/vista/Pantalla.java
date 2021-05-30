package vista;

import processing.core.PApplet;
import processing.core.PImage;

public abstract class Pantalla {
	
	
	protected PApplet app;
	protected int x;
	protected int y;
	protected int sizeX;
	protected int sizeY;
	protected PImage img;
	
	public Pantalla(PApplet app, int x, int y, int sizeX, int sizeY) {
		super();
		this.app = app;
		this.x = x;
		this.y = y;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}

	public Pantalla(PApplet app, int x, int y, int sizeX, int sizeY, PImage img) {
		super();
		this.app = app;
		this.x = x;
		this.y = y;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.img = img;
	}
	
	public abstract void pintar();
	
	public abstract void click();

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSizeX() {
		return sizeX;
	}

	public void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}

	public void setSizeY(int sizeY) {
		this.sizeY = sizeY;
	}

	public PImage getImg() {
		return img;
	}

	public void setImg(PImage img) {
		this.img = img;
	}
	
	
	
	

}
