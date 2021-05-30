package vista;

import java.util.ArrayList;

import modelo.Producto;
import processing.core.PApplet;
import processing.core.PImage;

public class Orden extends Pantalla{

	private Producto producto;
	private int min = 2;
	private int seg = 00;
	private ArrayList<Producto> adiciones;
	private int finalPrecio;
	
	private int pantalla = 2;
	

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
		this.app.fill(0);
		this.app.textSize(14);
		this.app.text(this.producto.getNombre(), 100, 100);
		this.app.text(this.producto.getPrecio()+".000", 240, 100);
		this.app.text(this.producto.getCantidad(), 300,100);
		for (Producto adicion : adiciones) {
			this.app.text(adicion.getNombre(), 100, 140 +(adiciones.indexOf(adicion)*40));
			this.app.text(adicion.getPrecio()+".000", 240, 140+(adiciones.indexOf(adicion)*40));
			this.app.text(adicion.getCantidad(), 300,140 +(adiciones.indexOf(adicion)*40));
		}
		
		this.app.text(this.finalPrecio + ".000", 240,460);
		
		if (pantalla == 4) {
			this.app.fill(255);
			this.app.rect(80, 528, 180, 30);
			
			this.app.fill(0);
			if(min!=00&&seg!=00) {
			this.app.text(min+" : "+seg,180,30);
			}else {
				this.app.text("su pedido ha llegado",180,30);	
			}
		}
	}
	
	public void counter() {
		new Thread (
				()->{
					for (int i = 0; i < 1800000; i++) {
						try {
							Thread.sleep(600);
							
							if(seg == 00){
								min -=1;
								seg = 60;
							}		
							seg -= 1;
							
							if(min==00&&seg==00) {
								return;
							}
							
							
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}).start();
	}

	@Override
	public void click() {
		if (this.app.mouseX > 121 && this.app.mouseX <  251 && this.app.mouseY > 530 && this.app.mouseY < 555) {
			pantalla = 3;
			
		}
		
	}
	
	public int getPantalla() {
		return pantalla;
	}


	public void setPantalla(int pantalla) {
		this.pantalla = pantalla;
	}


	public void finalPrecio() {
		int precioAdiciones = 0;
		for (Producto adicion : adiciones) {
			precioAdiciones = precioAdiciones+=adicion.getPrecio()*adicion.getCantidad();
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
