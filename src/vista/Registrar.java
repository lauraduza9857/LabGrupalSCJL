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
	private Boolean pj5 = true;
	private int pantalla = 6;
	private int errores = 0;
	private boolean primer = false;

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

		usuarios = new ArrayList<>();

		input = new String [6];	
		

	}
	public void errore() {
		switch (errores) {
		case 0:
			this.app.fill(0);

			this.app.text("",0, 0);
			break;
		case 1: 
			this.app.fill(0);

			this.app.text("Este email ya existe",(app.width/2-150), 480);
			break;
		case 2: 
			this.app.fill(0);

			this.app.text("Esta contraseña ya existe",(app.width/2-150), 480);
			break;
		default:
			break;
		}
	}

	public void registrarUser() {

		String nombre =p5.get(Textfield.class, "Nombre").getText();
		String apellido =p5.get(Textfield.class, "Apellido").getText();
		String ciudad =p5.get(Textfield.class, "Ciudad").getText();
		String direccion =p5.get(Textfield.class, "Dirección").getText();
		String email =p5.get(Textfield.class, "Email").getText();
		String contraseña =p5.get(Textfield.class, "Contraseña").getText();

		if (primer == false) {
			Usuario us = new Usuario(nombre, apellido, ciudad, direccion, email, contraseña, 0);

			usuarios.add(us);
			primer = true;

			p5.get(Textfield.class, "Nombre").setText("");
			p5.get(Textfield.class, "Apellido").setText("");
			p5.get(Textfield.class, "Ciudad").setText("");
			p5.get(Textfield.class, "Dirección").setText("");
			p5.get(Textfield.class, "Email").setText("");
			p5.get(Textfield.class, "Contraseña").setText("");
			pantalla = 0;
			
			pj5 = false;
		} else {

			for (int i = 0; i < usuarios.size(); i++) {

				Boolean emailC = email.equals(usuarios.get(i).getEmail());
				System.out.println(email);
				System.out.println(usuarios.get(i).getEmail());
				Boolean contras = contraseña.equals(usuarios.get(i).getContraseña());

				if( emailC == true) {
					new Thread (
							()->{
								for (int j = 0; j < 5; j++) {
									try {
										Thread.sleep(1000);

										errores = 1;


										System.out.println("entro");


									}
									catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();

									}
								}
								errores = 0;
								return;
							}
							).start();

				} else if (contras == true) {
					new Thread (
							()->{
								for (int j = 0; j < 5; j++) {
									try {
										Thread.sleep(1000);

										errores = 2;   



									}
									catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();

									}
								}
								errores = 0;
								
							}
							).start();
					
				} else {		

					Usuario us = new Usuario(nombre, apellido, ciudad, direccion, email, contraseña, 0);

					usuarios.add(us);
					primer = true;

					p5.get(Textfield.class, "Nombre").setText("");
					p5.get(Textfield.class, "Apellido").setText("");
					p5.get(Textfield.class, "Ciudad").setText("");
					p5.get(Textfield.class, "Dirección").setText("");
					p5.get(Textfield.class, "Email").setText("");
					p5.get(Textfield.class, "Contraseña").setText("");

					if (usuarios.get(i).getEmail().equals(email)) {
						usuarios.get(i).setPos(i);

					}
					pj5 = false;
					pantalla = 0;

				}
				
			}
		}

	}


	public Boolean getPj5() {
		return pj5;
	}

	public void setPj5(Boolean pj5) {
		this.pj5 = pj5;
	}

	public void mostrarP5(){
		input [0] = "Nombre";
		input [1] = "Apellido";
		input [2] = "Ciudad";
		input [3] = "Dirección";
		input [4] = "Email";
		input [5] = "Contraseña";

		

		p5.addTextfield(input[0]).setPosition((app.width/2-126),103).setSize(252,38).setAutoClear(true)
		.setColorBackground(app.color(255,255,255)).setColorActive(app.color(0)).setColorValueLabel(app.color(0))
		.setFont(app.createFont("Arial", 20));

		p5.addTextfield(input[1]).setPosition((app.width/2-126),171).setSize(252,38).setAutoClear(true)
		.setColorBackground(app.color(255,255,255)).setColorActive(app.color(0)).setColorValueLabel(app.color(0))
		.setFont(app.createFont("Arial", 20));

		p5.addTextfield(input[2]).setPosition((app.width/2-126),239).setSize(252,38).setAutoClear(true)
		.setColorBackground(app.color(255,255,255)).setColorActive(app.color(0)).setColorValueLabel(app.color(0))
		.setFont(app.createFont("Arial", 20));

		p5.addTextfield(input[3]).setPosition((app.width/2-126),307).setSize(252,38).setAutoClear(true)
		.setColorBackground(app.color(255,255,255)).setColorActive(app.color(0)).setColorValueLabel(app.color(0))
		.setFont(app.createFont("Arial", 20));

		p5.addTextfield(input[4]).setPosition((app.width/2-126),375).setSize(252,38).setAutoClear(true)
		.setColorBackground(app.color(255,255,255)).setColorActive(app.color(0)).setColorValueLabel(app.color(0))
		.setFont(app.createFont("Arial", 20));

		p5.addTextfield(input[5]).setPosition((app.width/2-126),443).setSize(252,38).setAutoClear(true)
		.setColorBackground(app.color(255,255,255)).setColorActive(app.color(0)).setColorValueLabel(app.color(0))
		.setFont(app.createFont("Arial", 20)).setPasswordMode(true);
	}
	
	public void hideP5() {
		p5.remove("Nombre");
		p5.remove("Apellido");
		p5.remove("Ciudad");
		p5.remove("Ciudad");
		p5.remove("Dirección");
		p5.remove("Contraseña");
		p5.hide();
	}

	@Override
	public void pintar() {
		this.app.image(img, x, y, sizeX, sizeY);		
		errore();
	}

	@Override
	public void click() {
		if (this.app.mouseX > 107 && this.app.mouseX <  257 && this.app.mouseY > 542 && this.app.mouseY < 581) {
			registrarUser();

			
		}

	}

}
