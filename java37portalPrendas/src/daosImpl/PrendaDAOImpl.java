package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;








import com.mysql.jdbc.Statement;

import utilidades.GestorArchivos;
import modelo.Cliente;
import modelo.Prenda;
import daos.ConstantesSQL;
import daos.GenericDAO;
import daos.PrendaDAO;

public class PrendaDAOImpl extends GenericDAO implements PrendaDAO {

	@Override
	public void registarPrenda(Prenda prenda) {
		
		conectar();
		try {
		
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.INSERCION_PRENDA,Statement.RETURN_GENERATED_KEYS);
			
	
			ps.setString(1, prenda.getArticulo());	
			ps.setString(2, prenda.getColor());
			ps.setString(3, prenda.getDetalles());
			ps.setString(4, prenda.getUnidades());
			ps.setString(5, prenda.getTalla());
			ps.setString(6, prenda.getPrecio());
			ps.setString(7, prenda.getTipo_material());
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int idGenerado = rs.getInt(1);
				System.out.println("Id generado en bd: " + idGenerado);

				// guardar la imagen del producto en una carpeta nombrada con el
				// mismo id generado
				GestorArchivos.guardarArchivo(prenda.getImagenSubida(), idGenerado
						+ ".jpg");
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println("ERROR!! la SQL de insercion de prenda esta mal");
			System.out.println(e.getMessage());
		}
		desconectar();
	}
	@Override
	public List<Prenda> obtenerPrenda() {
		conectar();
		List<Prenda> prendas = new ArrayList<Prenda>();
		
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.SELECION_PRENDA);
			ResultSet resultado = ps.executeQuery();
			
			while(resultado.next()){
				Prenda prenda = new Prenda();
				
				prenda.setArticulo(resultado.getString("articulo"));
				prenda.setColor(resultado.getString("color"));
				prenda.setDetalles(resultado.getString("detalles"));
				prenda.setUnidades(resultado.getString("unidades"));
				prenda.setTalla(resultado.getString("talla"));
				prenda.setPrecio(resultado.getString("precio"));
				prenda.setTipo_material(resultado.getString("tipo_material"));
				
				prenda.setId(resultado.getInt("id"));
				
				prenda.setRutaImagen(GestorArchivos.rutaArchivo(resultado.getInt(("id"))));
				
				prendas.add(prenda);
			}
			
		} catch (SQLException e) {
			System.out.println("ERROR!! SQL select esta mal, revisala");
		}
		desconectar();
		return prendas;
	}

	@Override
	public void borrarPrenda(int id) {
		conectar();
		
		PreparedStatement ps;
		try {
			ps = miConexion.prepareStatement(ConstantesSQL.BORRAR_PRENDA);
			
			ps.setInt(1, id);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR!! en la SQL");
			System.out.println(e.getMessage());
		}
		desconectar();	

	}

	@Override
	public Prenda obtenerPrendaPorId(int id) {
		conectar();
		
		Prenda prenda = new Prenda();
		
		PreparedStatement ps;
		
		try {
			ps = miConexion.prepareStatement(ConstantesSQL.OBTENER_PRENDA_POR_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				prenda.setArticulo(rs.getString("articulo"));
				prenda.setColor(rs.getString("color"));
				prenda.setDetalles(rs.getString("detalles"));
				prenda.setUnidades(rs.getString("unidades"));
				prenda.setTalla(rs.getString("talla"));
				prenda.setPrecio(rs.getString("precio"));
				prenda.setTipo_material(rs.getString("tipo_material"));
				prenda.setId(id);				
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println("ERROR!! en la SQL");
			System.out.println(e.getMessage());
		}
		desconectar();	
		
		return prenda;
	}

	@Override
	public void guardarCambiosPrenda(Prenda prenda) {
		conectar();
		PreparedStatement ps;
		try {
			ps = miConexion.prepareStatement(ConstantesSQL.GUARDAR_CAMBIOS_PRENDA);
			ps.setString(1, prenda.getArticulo());
			ps.setString(2, prenda.getColor());
			ps.setString(3, prenda.getDetalles());
			ps.setString(4, prenda.getUnidades());
			ps.setString(5, prenda.getTalla());
			ps.setString(6, prenda.getPrecio());
			ps.setString(7, prenda.getTipo_material());
			ps.setInt(8,prenda.getId());
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR!! en la SQL de guardar cambios este mal");
			System.out.println(e.getMessage());
		}
		
		desconectar();	
	}

}




