package vista;

import java.util.ArrayList;

import modelo.Producto;
import processing.core.PApplet;

public class Main extends PApplet{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(Main.class.getName());
	}
		
	Menu pantallaMenu;
	Adiciones pantallaAdiciones;
	Producto producto;
	static ArrayList<Producto> adiciones;
	Orden pantallaOrden;
	int pantalla;
	
	public void settings() {
		size(375, 667);
	}
	
	public void setup() {
		pantalla = 0;
		pantallaMenu = new Menu(this, 0, 0, 375, 667, loadImage("./img/Menu.png"));
		pantallaAdiciones = new Adiciones(this, 0, 0, 375, 667, loadImage("./img/Adiciones.png"));
		pantallaOrden = new Orden(this, 0, 0, 375, 667,  loadImage("./img/Pago.jpeg"), null, null);
		adiciones = new ArrayList<Producto>();
	}
	
	public void draw() {
		if(pantalla==0) {
			pantallaMenu.pintar();
		}
		if(pantalla==1) {
			pantallaAdiciones.pintar();
		}
		if(pantalla==2) {
			pantallaOrden.pintar();
		}
		
	}
	
	public void mouseClicked() {
		if(pantalla == 0) {
			pantallaMenu.click();
			switch (pantallaMenu.getPizzaSeleccionada()) {
			case 1:
				producto = new Producto("Pizza de la casa", 15, 1,1);
				pantallaOrden.setProducto(producto);
				pantalla = 1;
				break;
				
			case 2:
				producto = new Producto("Pizza del pacifico", 19, 1,1);
				pantallaOrden.setProducto(producto);
				pantalla = 1;
				break;
				
			case 3:
				producto = new Producto("Pizza clásica", 12, 1,1);
				pantallaOrden.setProducto(producto);
				pantalla = 1;
				break;

			default:
				break;
			}
		}
		
		if(pantalla == 1) {
			pantallaAdiciones.click();
			
			if(pantallaAdiciones.agregar.isSeleccionado()) {
				pantallaAdiciones.ponerAdiciones();
				pantallaOrden.setAdiciones(adiciones);
				pantallaOrden.finalPrecio();
				pantalla = 2;
			}
		}
		
		
		
		
	}
	
	public static void addAdiciones(Producto product) {
		adiciones.add(product);
	}

}
