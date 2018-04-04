package daos;

public class ConstantesSQL {
	
	public static final String IDENTIFICACION_ADMIN = 
			"SELECT id FROM tabla_admin WHERE login = ? AND pass = ?";
	
	
	
	public static final String INSERCION_CLIENTE = 
			"INSERT INTO tabla_cliente "
			+ "(nombre, calle, numeracion, codigo_postal, poblacion, telefono, email, particula_empresa)"
			+ " VALUES (?,?,?,?,?,?,?,?)";
	
	public static final String SELECION_CLIENTE = 
			"SELECT * FROM tabla_cliente ";
	
	public static final String BORRAR_CLIENTE = 
			"DELETE FROM tabla_cliente WHERE id = ?";
	
	public static final String OBTENER_CLIENTE_POR_ID = 
			"SELECT * FROM tabla_cliente WHERE id = ? ";

	public static final String GUARDAR_CAMBIOS_CLIENTE = 
			"UPDATE tabla_cliente SET nombre= ?, calle= ?, numeracion= ?, codigo_postal = ?, poblacion= ?, email= ?, telefono= ?, particula_empresa= ?  WHERE id = ?";
	
	
	
	
	public static final String INSERCION_PRENDA = 
			"INSERT INTO tabla_prenda (articulo, color,	detalles, unidades, talla, precio, tipo_material)"
			+ " VALUES (?,?,?,?,?,?,?)";
	
	public static final String SELECION_PRENDA = 
			"SELECT * FROM tabla_prenda ";
	
	public static final String BORRAR_PRENDA = 
			"DELETE FROM tabla_prenda WHERE id = ?";


	public static final String OBTENER_PRENDA_POR_ID = 
			"SELECT * FROM tabla_prenda WHERE id = ? ";

	public static final String GUARDAR_CAMBIOS_PRENDA = 
			"UPDATE tabla_prenda SET articulo= ?, color= ?, detalles= ?, unidades= ?, talla= ?, precio= ?, tipo_material= ? WHERE id = ?";

	

	
	
	
	
	
			
		

}
