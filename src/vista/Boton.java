package vista;

import processing.core.PApplet;

public class Boton extends Elemento{

	private String contenido;
	private boolean isSum;

	public Boton(PApplet app, int x, int y, int sizeX, int sizeY, String contenido, int cantidad, boolean isSum) {
		super(app, x, y, sizeX, sizeY);
		// TODO Auto-generated constructor stub
		this.contenido = contenido;
		this.isSum = isSum;
		
	}
// SG
	@Override
	public void pintar() {
		// TODO Auto-generated method stub
		this.app.noStroke();
		this.app.fill(255);
		this.app.rect(x, y, sizeX, sizeY);
		this.app.fill(0);
		this.app.text(contenido, x+sizeX/2, y+sizeY/2);
	}
	
	public int operacion(int cant) {
		
		if(isSeleccionado()) {
			if(isSum) {
				cant++;
			} else {
				cant--;

			}
		}
		return cant;
	}

}
