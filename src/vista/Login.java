package vista;

import java.util.ArrayList;

import controlP5.ControlP5;
import controlP5.Textfield;
import processing.core.PApplet;
import processing.core.PImage;

public class Login extends Pantalla{
	private ControlP5 p5;
	private ArrayList<Usuario> usuarios;
	private String[] input;
	private Boolean pj5 = true;
	private int pantalla = 6;


	public Login(PApplet app, int x, int y, int sizeX, int sizeY, PImage img) {
		super(app, x, y, sizeX, sizeY, img);
		p5 = new ControlP5(app);

		usuarios = new ArrayList<>();

		input = new String [6];	
		
	}

	@Override
	public void pintar() {
		this.app.image(img, x, y, sizeX, sizeY);

	}

	@Override
	public void click() {

		String email =p5.get(Textfield.class, "Email").getText();
		String contr =p5.get(Textfield.class, "Contraseña").getText();

		if (this.app.mouseX > 189 && this.app.mouseX <  257 && this.app.mouseY > 541 && this.app.mouseY < 580) {
			for (int i = 0; i < usuarios.size(); i++) {
				if(usuarios.get(i).getEmail().equals(email) || usuarios.get(i).getContrase�a().equals(contr)) {
					new Thread(
							()->{


								this.app.fill(0);

								this.app.text("Este usuario ya existe, registrese",(app.width/2-150), 480);
								try {
									Thread.sleep(3000);
									pantalla = 6;
									p5.get(Textfield.class, "Email").setText("");
									p5.get(Textfield.class, "Contraseña").setText("");
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								return;

							}

							).start();
				} else {
					pj5 = false;
					pantalla = 0;
					p5.get(Textfield.class, "Email").setText("");
					p5.get(Textfield.class, "Contraseña").setText("");
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

	public void mostrarP5(){
		input [0] = "Email";
		input [1] = "Contraseña";

		p5.addTextfield(input[0]).setPosition((app.width/2-126),420).setSize(252,38).setAutoClear(true)
		.setColorBackground(app.color(255,255,255)).setColorCaptionLabel(this.app.color(0)).setColorActive(app.color(0)).setColorValueLabel(app.color(0))
		.setFont(app.createFont("Arial", 20));

		p5.addTextfield(input[1]).setPosition((app.width/2-126),485).setSize(252,38).setAutoClear(true)
		.setColorBackground(app.color(255,255,255)).setColorCaptionLabel(this.app.color(0)).setColorActive(app.color(0)).setColorValueLabel(app.color(0))
		.setFont(app.createFont("Arial", 20)).setPasswordMode(true);
	}
	public void hideP5() {
		p5.remove("Email");
		p5.remove("Contraseña");
	}

}
