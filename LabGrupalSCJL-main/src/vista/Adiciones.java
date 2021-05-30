package vista;

import java.util.ArrayList;

import modelo.Adition;
import modelo.AditionButton;
import modelo.Pizza;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Adiciones extends Pantalla {
	
	Adition ad0 = new Adition("Pimenton", 3, 0,1);
	Adition ad1 = new Adition("Camarones", 15, 0,2);
	Adition ad2 = new Adition("Cebollas", 15, 0,3);
	Adition ad3 = new Adition("Jugo de Naranja", 15, 0,4);
	Adition ad4 = new Adition("Coca Cola", 15, 0,5);
	Adition ad5 = new Adition("canelones", 15, 0, 6);
	Pizza pizza;
	ArrayList<Adition> aditions = new ArrayList<>();
	ArrayList<AditionButton> buttonsAdd = new ArrayList<AditionButton>();
	ArrayList<AditionButton> buttonsSub = new ArrayList<AditionButton>();
	Boton agregar;
	
	public Adiciones(PApplet app, int x, int y, int sizeX, int sizeY, PImage img) {
		super(app, x, y, sizeX, sizeY, img);
		aditions.add(ad0);
		aditions.add(ad1);
		aditions.add(ad2);
		aditions.add(ad3);
		aditions.add(ad4);
		aditions.add(ad5);
		agregar = new Boton(app,140,556,100,50, "Agregar");

		for (int i = 0; i < 5; i++) {
			buttonsAdd.add( new AditionButton(app, 250, (i * 100) + 100, 25, 25, "+", aditions.get(i), true));
		}

		for (int i = 0; i < 5; i++) {
			buttonsAdd.add( new AditionButton(app, 350, (i * 100) + 100, 25, 25, "-", aditions.get(i), false));
		}
		
	}

	@Override
	public void pintar() {

		this.app.image(img, x, y, sizeX, sizeY);
		for (AditionButton button : buttonsSub) {
			button.pintar();
		}
		
		for (AditionButton button : buttonsAdd) {
			button.pintar();
		}
		this.app.fill(0);
		this.app.textSize(18);
		this.app.textAlign(PConstants.CENTER,PConstants.CENTER);
		for(int i = 0 ; i < aditions.size() ; i++){
			this.app.text(aditions.get(i).cantidad, 225 + 10, (110 + i * 100));
		}
		this.app.text(calcFinalPrice(), 100, 200 );

	}

	@Override
	public void click() {
		for(AditionButton button : buttonsSub){
			if(button.isSeleccionado()) button.operateAdition();
		}
		for(AditionButton button : buttonsAdd){
			if(button.isSeleccionado()) button.operateAdition();
		}

		if(agregar.isSeleccionado()){
			this.pizza.setAditions(this.aditions);
		}
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	private int calcFinalPrice() {
		int total = pizza.valor;
		for(Adition adition: aditions){
			total += adition.cantidad * adition.precio;
		}
		return total;
	}

	public Pizza getPizzaWithToppings(){
		return this.pizza;
	}
}
