package vista;

import java.util.ArrayList;

import modelo.Adition;
import processing.core.PApplet;

public class Main extends PApplet{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(Main.class.getName());
	}
		
	Menu pantallaMenu;
	Adiciones pantallaAdiciones;
	Adition adition;
	static ArrayList<Adition> adiciones;
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
		adiciones = new ArrayList<Adition>();
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
			switch (pantallaMenu.getPizzaSeleccionada().id) {
			case 0:
				adition = new Adition("Pizza de la casa", 15, 1,1);
				pantallaOrden.setProducto(adition);
				break;
				
			case 1:
				adition = new Adition("Pizza del pacifico", 19, 1,1);
				pantallaOrden.setProducto(adition);
				break;
				
			case 2:
				adition = new Adition("Pizza cl�sica", 12, 1,1);
				pantallaOrden.setProducto(adition);
				break;
			default:
				break;
			}
			pantallaAdiciones.setPizza(pantallaMenu.getPizzaSeleccionada());
			pantalla = 1;
		}
		
		if(pantalla == 1) {
			pantallaAdiciones.click();
			if(pantallaAdiciones.agregar.isSeleccionado()){
				pantalla = 2;
			}
		}
	}
	
	public static void addAdiciones(Adition product) {
		adiciones.add(product);
	}

}
