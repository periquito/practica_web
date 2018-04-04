package modelo;

import javax.servlet.http.Part;

public class Prenda {
	
	private String articulo;
	private String color;
	private String detalles;
	private String unidades;
	private String talla;
	private String precio;
	private String tipo_material;
	private int id;
	private Part imagenSubida;
	private String rutaImagen;

	
	
	public Prenda() {		
	}

	public Prenda(String articulo, String color, String detalles, String unidades ,String talla, String precio, String tipo_material, Part imagenSubida ) {
		super();
		this.articulo = articulo;
		this.color = color;
		this.detalles = detalles;
		this.unidades = unidades;
		this.color = color;
		this.talla = talla;
		this.precio = precio;
		this.tipo_material = tipo_material;
		this.imagenSubida = imagenSubida;
	}

	public String getArticulo() {
		return articulo;
	}

	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	public String getUnidades() {
		return unidades;
	}

	public void setUnidades(String unidades) {
		this.unidades = unidades;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getTipo_material() {
		return tipo_material;
	}

	public void setTipo_material(String tipo_material) {
		this.tipo_material = tipo_material;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Prenda [articulo=" + articulo + ", color=" + color
				+ ", detalles=" + detalles + ", unidades=" + unidades
				+ ", talla=" + talla + ", precio=" + precio
				+ ", tipo_material=" + tipo_material + ", id=" + id + "]";
	}

	public Part getImagenSubida() {
		return imagenSubida;
	}

	public void setImagenSubida(Part imagenSubida) {
		this.imagenSubida = imagenSubida;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	
	

	
	

}//end clss
