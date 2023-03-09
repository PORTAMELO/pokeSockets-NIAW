package co.edu.unbosque.model;

public class PokemonDTO {
	String usuario, password, nombre, tipo;
	double peso, altura, velocidad;
	int edad, ataque, defensa;

	public PokemonDTO(String usuario, String password, String nombre, String tipo, double peso, double altura,
			double velocidad, int edad, int ataque, int defensa) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.nombre = nombre;
		this.tipo = tipo;
		this.peso = peso;
		this.altura = altura;
		this.velocidad = velocidad;
		this.edad = edad;
		this.ataque = ataque;
		this.defensa = defensa;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

}
