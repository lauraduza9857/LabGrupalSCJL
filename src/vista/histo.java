package vista;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShapeSVG.Text;

public abstract class histo {

	protected PApplet app;
	protected int x;
	protected int y;
	protected int id;




	public histo(PApplet app, int x, int y, int id) {
		super();
		this.app = app;
		this.x = x;
		this.y = y;
		this.id = id;

	}



	

	public abstract void pintar();

	public void pintarDefecto(int precio, int cantidad) {

app.text(id+" "+precio+" "+cantidad, x, y);


	
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


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




}
