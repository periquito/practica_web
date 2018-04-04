package modelo;

public class Cliente {
	
	private String nombre;
	private String calle;
	private String numeracion;
	private String codigo_postal;
	private String poblacion;
	private String telefono;
	private String email;
	private String particula_empresa;
	private int id;

	public Cliente() {		
	}

	public Cliente(String nombre, String calle, String numeracion, String codigo_postal ,String poblacion, String telefono, String email, String particula_empresa) {
		super();
		this.nombre = nombre;
		this.calle = calle;
		this.numeracion = numeracion;
		this.codigo_postal = codigo_postal;
		this.poblacion = poblacion;
		this.telefono = telefono;
		this.email = email;
		this.particula_empresa = particula_empresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumeracion() {
		return numeracion;
	}

	public void setNumeracion(String numeracion) {
		this.numeracion = numeracion;
	}

	public String getCodigo_postal() {
		return codigo_postal;
	}

	public void setCodigo_postal(String codigo_postal) {
		this.codigo_postal = codigo_postal;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getParticula_empresa() {
		return particula_empresa;
	}

	public void setParticula_empresa(String particula_empresa) {
		this.particula_empresa = particula_empresa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", calle=" + calle
				+ ", numeracion=" + numeracion + ", codigo_postal="
				+ codigo_postal + ", poblacion=" + poblacion + ", telefono="
				+ telefono + ", email=" + email + ", particula_empresa="
				+ particula_empresa + ", id=" + id + "]";
	}

	
}//end clss
