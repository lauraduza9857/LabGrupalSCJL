package vista;

import java.util.ArrayList;

import modelo.Producto;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Adiciones extends Pantalla{
	
	Producto adiccion0 = new Producto("Piment�n", 3, 10,1);
	Producto adiccion1 = new Producto("Camarones", 15, 11,1);
	Producto adiccion2 = new Producto("Cebollas", 15, 12,1);
	Producto adiccion3 = new Producto("Jugo de Naranja", 15, 13,1);
	Producto adiccion4 = new Producto("Coca Cola", 15, 14,1);
	int cant1,cant2,cant3,cant4,cant5,cant6;
	ArrayList<Boton> btnSumar;
	ArrayList<Boton> btnRestar;
	Boton agregar;
	
	public Adiciones(PApplet app, int x, int y, int sizeX, int sizeY, PImage img) {
		super(app, x, y, sizeX, sizeY, img);
		// TODO Auto-generated constructor stub
		btnSumar = new ArrayList<Boton>();
		btnRestar = new ArrayList<Boton>();
		agregar = new Boton(app,140,556,100,50, "Agregar",0, true);
		cant1 = 0;
		cant2 = 0;
		cant3 = 0;
		cant4 = 0;
		cant5 = 0;
		cant6 = 0;
		
		for (int i = 0; i < 5; i++) {
			btnSumar.add( new Boton(app, 250, (i*100)+100, 25, 25, "+", 0, true));
		}
		
		for (int i = 0; i < 5; i++) {
			btnRestar.add( new Boton(app, 300, (i*100)+100, 25, 25, "-", 0, false));
		}
		
	}

	@Override
	public void pintar() {
		// TODO Auto-generated method stub
		this.app.image(img, x, y, sizeX, sizeY);
		for (Boton boton : btnRestar) {
			boton.pintar();
		}
		
		for (Boton boton : btnSumar) {
			boton.pintar();
		}
		this.app.fill(0);
		this.app.textSize(18);
		this.app.textAlign(PConstants.CENTER,PConstants.CENTER);
		
			this.app.text(cant1, 225+10, 110);
			this.app.text(cant2, 225+10, 210);
			this.app.text(cant3, 225+10, 310);
			this.app.text(cant4, 225+10, 410);
			this.app.text(cant5, 225+10, 510);
			
			//agregar.pintar();
		
	}

	@Override
	public void click() {
		// TODO Auto-generated method stub
		for(int i=0; i<btnRestar.size(); i++) {
			if(btnRestar.get(i).isSeleccionado() || btnSumar.get(i).isSeleccionado()) {
				switch (btnRestar.indexOf(btnRestar.get(i))) {
				case 0:
					if(btnRestar.get(i).isSeleccionado()) {
						cant1 = btnRestar.get(i).operacion(cant1);
					}
					if(btnSumar.get(i).isSeleccionado()) {
						cant1 = btnSumar.get(i).operacion(cant1);
					}
					break;
				case 1:
					if(btnRestar.get(i).isSeleccionado()) {
						cant2 = btnRestar.get(i).operacion(cant2);
					}
					if(btnSumar.get(i).isSeleccionado()) {
						cant2 = btnSumar.get(i).operacion(cant2);
					}
					break;
				case 2:
					if(btnRestar.get(i).isSeleccionado()) {
						cant3 = btnRestar.get(i).operacion(cant3);
					}
					if(btnSumar.get(i).isSeleccionado()) {
						cant3 = btnSumar.get(i).operacion(cant3);
					}
					break;
				case 3:
					if(btnRestar.get(i).isSeleccionado()) {
						cant4 = btnRestar.get(i).operacion(cant4);
					}
					if(btnSumar.get(i).isSeleccionado()) {
						cant4 = btnSumar.get(i).operacion(cant4);
					}
					break;
				case 4:
					if(btnRestar.get(i).isSeleccionado()) {
						cant5 = btnRestar.get(i).operacion(cant5);
					}
					if(btnSumar.get(i).isSeleccionado()) {
						cant5 = btnSumar.get(i).operacion(cant5);
					}
					break;
				case 5:
					if(btnRestar.get(i).isSeleccionado()) {
						cant6 = btnRestar.get(i).operacion(cant6);
					}
					if(btnSumar.get(i).isSeleccionado()) {
						cant6 = btnSumar.get(i).operacion(cant6);
					}
					break;

				default:
					break;
				}
			}
			
		}
		
		
	}
	
	public void ponerAdiciones() {
		
		if(cant1 > 0) {
			Main.addAdiciones(new Producto("Piment�n", 3, cant1, 10));
		}
		if(cant2 > 0) {
			Main.addAdiciones(new Producto("Camarones", 3, cant2, 11));
		}
		if(cant3 > 0) {
			Main.addAdiciones(new Producto("Cebollas", 3, cant3, 12));
		}
		if(cant4 > 0) {
			Main.addAdiciones(new Producto("Jugo de Naranja", 8, cant4, 13));
		}
		if(cant5 > 0) {
			Main.addAdiciones(new Producto("Coca Cola", 7, cant5, 14));
		}
		
	}

	
}
