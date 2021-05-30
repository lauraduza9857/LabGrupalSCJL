package vista;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Menu extends Pantalla{
	
	public ArrayList<Elemento> pizzas;
	private int pizzaSeleccionada;


	public Menu(PApplet app, int x, int y, int sizeX, int sizeY, PImage img) {
		super(app, x, y, sizeX, sizeY, img);
	
		// TODO Auto-generated constructor stub
		pizzas = new ArrayList<Elemento>();
		for (int i = 0; i < 3; i++) {
			
			pizzas.add(new Elemento(app, 30, (150*i)+150, 325, 125) {
				
				@Override
				public void pintar() {
					// TODO Auto-generated method stub
					
				}
			});
			
		}
	}

	@Override
	public void pintar() {
		// TODO Auto-generated method stub
		this.app.image(img, x, y, sizeX, sizeY);
		for (Elemento pizza : pizzas) {
			pizza.pintarDefecto();
		}
		
		this.app.tint(255, 128);
	}

	@Override
	public void click() {
		// TODO Auto-generated method stub
		for (int i = 0; i < pizzas.size(); i++) {
			if(pizzas.get(i).isSeleccionado()) {
		
				pizzaSeleccionada = pizzas.indexOf(pizzas.get(i));
			}
			
		}
		System.out.println(getPizzaSeleccionada());

	}
	
	public int getPizzaSeleccionada() {
		return pizzaSeleccionada+1;
	}
	


}
