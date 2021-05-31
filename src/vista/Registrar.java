package vista;

import java.util.ArrayList;

import org.xml.sax.InputSource;

import controlP5.ControlP5;
import controlP5.Textfield;
import processing.core.PApplet;
import processing.core.PImage;

public class Registrar extends Pantalla{
	
	private ControlP5 p5;
	private ArrayList<Usuario> usuarios;
	private String[] input;
	private int pantalla = 6;

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public int getPantalla() {
		return pantalla;
	}

	public void setPantalla(int pantalla) {
		this.pantalla = pantalla;
	}

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
	
	public void registrarUser() {
String nombre =p5.get(Textfield.class, "Nombre").getText();
String apellido =p5.get(Textfield.class, "Apellido").getText();
String ciudad =p5.get(Textfield.class, "Ciudad").getText();
String direccion =p5.get(Textfield.class, "Dirección").getText();
String email =p5.get(Textfield.class, "Email").getText();
String contraseña =p5.get(Textfield.class, "Contraseña").getText();

Usuario us = new Usuario(nombre, apellido, ciudad, direccion, email, contraseña, 0);
	
usuarios.add(us);

for (int i = 0; i < usuarios.size(); i++) {
	if (usuarios.get(i).getEmail().equals(us.getEmail())) {
		usuarios.get(i).setPos(i);
	}
}

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
		if (this.app.mouseX > 107 && this.app.mouseX <  257 && this.app.mouseY > 542 && this.app.mouseY < 581) {
			registrarUser();
			pantalla = 7;
		}
		
	}

}
