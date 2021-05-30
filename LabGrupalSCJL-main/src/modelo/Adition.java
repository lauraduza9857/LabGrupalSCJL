package modelo;

public class Adition {

	private String nombre;
	public int precio;
	private int ID;
	public int cantidad;
	
	public Adition(String nombre, int precio, int cantidad, int ID) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		this.ID = ID;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public int getPrecio() {
		return precio;
	}

}
