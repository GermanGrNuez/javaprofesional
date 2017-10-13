package beans;

public class Cliente {
	
	private String nombre;
	private String email;
	private int telefono;
	private String password;

	
	public Cliente(String nombre, String email,String password, int telefono) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	
	
}
