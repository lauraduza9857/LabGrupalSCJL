package vista;

import org.xml.sax.InputSource;

import controlP5.ControlP5;
import processing.core.PApplet;
import processing.core.PImage;

public class Registrar extends Pantalla{
	
	private ControlP5 p5;
	private String[] input;

	public Registrar(PApplet app, int x, int y, int sizeX, int sizeY, PImage img) {
		super(app, x, y, sizeX, sizeY, img);
	p5 = new ControlP5(app);
	
	input = new String [6];	
	input [0] = "Nombre";
	input [1] = "Apellido";
	input [2] = "Ciudad";
	input [3] = "Dirección";
	input [4] = "Email";
	input [5] = "Contraseña";
	
	p5.hide();
	
	p5.addTextfield(input[0]).setPosition((app.width/2-126),103).setSize(252,38).setAutoClear(true)
	.setColorBackground(app.color(255,255,255)).setColorActive(app.color(0)).setColorValueLabel(app.color(0))
	.setFont(app.createFont("Arial", 20));
	
	p5.addTextfield(input[1]).setPosition((app.width/2-126),171).setSize(252,38).setAutoClear(true)
	.setColorBackground(app.color(255,255,255)).setColorActive(app.color(0)).setColorValueLabel(app.color(0))
	.setFont(app.createFont("Arial", 20));
	
	p5.addTextfield(input[2]).setPosition((app.width/2-126),223).setSize(252,38).setAutoClear(true)
	.setColorBackground(app.color(255,255,255)).setColorActive(app.color(0)).setColorValueLabel(app.color(0))
	.setFont(app.createFont("Arial", 20));
	
	p5.addTextfield(input[3]).setPosition((app.width/2-126),283).setSize(252,38).setAutoClear(true)
	.setColorBackground(app.color(255,255,255)).setColorActive(app.color(0)).setColorValueLabel(app.color(0))
	.setFont(app.createFont("Arial", 20));
	
	p5.addTextfield(input[4]).setPosition((app.width/2-126),343).setSize(252,38).setAutoClear(true)
	.setColorBackground(app.color(255,255,255)).setColorActive(app.color(0)).setColorValueLabel(app.color(0))
	.setFont(app.createFont("Arial", 20));
	
	p5.addTextfield(input[5]).setPosition((app.width/2-126),403).setSize(252,38).setAutoClear(true)
	.setColorBackground(app.color(255,255,255)).setColorActive(app.color(0)).setColorValueLabel(app.color(0))
	.setFont(app.createFont("Arial", 20)).setPasswordMode(true);

	}
	
	
	
	
	public void mostrarP5(){
		p5.show();
	}
	public void hideP5() {
		p5.hide();
	}

	@Override
	public void pintar() {
		this.app.image(img, x, y, sizeX, sizeY);		
	}

	@Override
	public void click() {
		// TODO Auto-generated method stub
		
	}

}
