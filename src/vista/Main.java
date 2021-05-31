package vista;

import java.util.ArrayList;
import modelo.Producto;
import processing.core.PApplet;

public class Main extends PApplet{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(Main.class.getName());
	}

	Registrar regis;
	Menu pantallaMenu;
	Check pantallaCheck;
	Adiciones pantallaAdiciones;
	Producto producto;
	Login login;
	static ArrayList<Producto> adiciones;
	private ArrayList<Usuario> usuarios;
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	Orden pantallaOrden;
	int pantalla;
	historial pantallaHISTORIA;

	boolean counter = false;

	public void settings() {
		size(375, 667);
	}

	public void setup() {
		pantalla = 6;
		regis=new Registrar(this,0, 0, 375, 667, loadImage("./img/REGISTRARSE.png"));
		login = new Login(this, 0, 0, 375, 667, loadImage("./img/PANTALLA_INICIO.png"));
		pantallaMenu = new Menu(this, 0, 0, 375, 667, loadImage("./img/Menu.png"));
		pantallaAdiciones = new Adiciones(this, 0, 0, 375, 667, loadImage("./img/Adiciones.png"));
		pantallaOrden = new Orden(this, 0, 0, 375, 667,  loadImage("./img/Pago.jpeg"), null, null);
		pantallaCheck = new Check(this, 0, 0, 375, 667, loadImage("./img/Orden_realizada.png"));
		pantallaHISTORIA = new historial(this, 0, 0, 375, 667,  loadImage("./img/historial.jpg"));
		adiciones = new ArrayList<Producto>();
	}

	public void draw() {

		if(pantalla==0) {
			regis.hideP5();
			pantallaMenu.pintar();
		}
		if(pantalla==1) {
			regis.hideP5();
			pantallaAdiciones.pintar();
		}
		if(pantalla==2) {
			regis.hideP5();
			pantallaOrden.pintar();
		}
		if(pantalla == 3) {
			regis.hideP5();
			pantallaCheck.pintar();
		}
		if (pantalla == 4) {
			regis.hideP5();
			pantallaOrden.setPantalla(pantalla);
			pantallaOrden.pintar();
		}
		if(pantalla == 5) {
			regis.hideP5();
			pantallaHISTORIA.pintar();
		}
		if(pantalla == 6) {
			regis.mostrarP5();
			regis.pintar();

		}
		if (pantalla == 7) {
			login.pintar();
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
				producto = new Producto("Pizza clasica", 12, 1,1);
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
		} else
			if (pantalla == 2) {
				pantallaOrden.click();
				pantalla = pantallaOrden.getPantalla();					
			}else

				if (pantalla == 3) {
					pantallaCheck.click();
					pantalla = pantallaCheck.getPantalla();
					counter = true;
					if (counter) {
						pantallaOrden.counter();
					}
				}else
					if(pantalla == 6){
						regis.click();
						pantalla =regis.getPantalla();
						setUsuarios(regis.getUsuarios());
					} 


		if (mouseX > 200 && mouseX <  250 && mouseY > 610 && mouseY < 660) {
			pantalla = 5;

		}
		if ((mouseX > 120 && mouseX <  190 && mouseY > 610 && mouseY < 660)&&counter==true) {
			pantalla = 4;

		}
		if ((mouseX > 45 && mouseX <  110 && mouseY > 610 && mouseY < 660)&&counter==true) {
			pantalla = 0;

		}

	}

	public static void addAdiciones(Producto product) {
		adiciones.add(product);
	}

}
