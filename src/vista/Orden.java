package vista;

import java.util.ArrayList;

import modelo.Producto;
import processing.core.PApplet;
import processing.core.PImage;

public class Orden extends Pantalla{

	private Producto producto;
	private ArrayList<Producto> adiciones;
	private int finalPrecio;

	public Orden(PApplet app, int x, int y, int sizeX, int sizeY, PImage img, Producto producto, ArrayList<Producto> adiciones) {
		super(app, x, y, sizeX, sizeY, img);
		// TODO Auto-generated constructor stub
		this.producto = producto;
		this.adiciones = adiciones;
		System.out.println(this.producto);
	}

	
	@Override
	public void pintar() {
		// TODO Auto-generated method stub
		this.app.image(img, x, y, sizeX, sizeY);
		this.app.textSize(14);
		this.app.text(this.producto.getNombre(), 100, 100);
		this.app.text(this.producto.getPrecio(), 200, 100);
		this.app.text(this.producto.getCantidad(), 240,100);
		for (Producto adicion : adiciones) {
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
		for (Producto adicion : adiciones) {
			precioAdiciones = precioAdiciones+=adicion.getPrecio();
		}
		finalPrecio = precioAdiciones + producto.getPrecio();
	}
	
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public ArrayList<Producto> getAdiciones() {
		return adiciones;
	}


	public void setAdiciones(ArrayList<Producto> adiciones) {
		this.adiciones = adiciones;
	}


}