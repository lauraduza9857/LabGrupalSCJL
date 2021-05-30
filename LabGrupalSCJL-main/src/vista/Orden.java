package vista;

import java.util.ArrayList;

import modelo.Adition;
import processing.core.PApplet;
import processing.core.PImage;

public class Orden extends Pantalla{

	private Adition adition;
	private ArrayList<Adition> adiciones;
	private int finalPrecio;

	public Orden(PApplet app, int x, int y, int sizeX, int sizeY, PImage img, Adition adition, ArrayList<Adition> adiciones) {
		super(app, x, y, sizeX, sizeY, img);
		// TODO Auto-generated constructor stub
		this.adition = adition;
		this.adiciones = adiciones;
		System.out.println(this.adition);
	}

	
	@Override
	public void pintar() {
		// TODO Auto-generated method stub
		this.app.image(img, x, y, sizeX, sizeY);
		this.app.textSize(14);
		this.app.text(this.adition.getNombre(), 100, 100);
		this.app.text(this.adition.getPrecio(), 200, 100);
		this.app.text(this.adition.getCantidad(), 240,100);
		for (Adition adicion : adiciones) {
			this.app.text(adicion.getNombre(), 100, 120 +(adiciones.indexOf(adicion)*20));
			this.app.text(adicion.getPrecio(), 200, 120+(adiciones.indexOf(adicion)*20));
			this.app.text(adicion.getCantidad(), 240,120 +(adiciones.indexOf(adicion)*20));
		}
		
		this.app.text(this.finalPrecio + ".000", 240,460);
	}

	@Override
	public void click() {
		// TODO Auto-generated method stub
		
	}
	
	public void finalPrecio() {
		int precioAdiciones = 0;
		for (Adition adicion : adiciones) {
			precioAdiciones = precioAdiciones+=adicion.getPrecio();
		}
		finalPrecio = precioAdiciones + adition.getPrecio();
	}
	
	public Adition getProducto() {
		return adition;
	}

	public void setProducto(Adition adition) {
		this.adition = adition;
	}


	public ArrayList<Adition> getAdiciones() {
		return adiciones;
	}


	public void setAdiciones(ArrayList<Adition> adiciones) {
		this.adiciones = adiciones;
	}


}
