package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;








import modelo.Cliente;


import modelo.Prenda;
import daos.ClienteDAO;
import daos.ConstantesSQL;
import daos.GenericDAO;



public class ClienteDAOImpl extends GenericDAO implements ClienteDAO{

	@Override
	public List<Cliente> obtenerCliente() {
		conectar();
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.SELECION_CLIENTE);
			ResultSet resultado = ps.executeQuery();
			
			while(resultado.next()){
				Cliente cliente = new Cliente();
				
				cliente.setNombre(resultado.getString("nombre"));
				cliente.setCalle(resultado.getString("calle"));
				cliente.setNumeracion(resultado.getString("numeracion"));
				cliente.setCodigo_postal(resultado.getString("codigo_postal"));
				cliente.setPoblacion(resultado.getString("poblacion"));
				cliente.setTelefono(resultado.getString("telefono"));
				cliente.setEmail(resultado.getString("email"));
				cliente.setParticula_empresa(resultado.getString("particula_empresa"));
				
				cliente.setId(resultado.getInt("id"));
				clientes.add(cliente);
			}
			
		} catch (SQLException e) {
			System.out.println("ERROR!! SQL select esta mal, revisala");
		}
		desconectar();
		return clientes;
	}

	@Override
	public Cliente obtenerClientePorId(int id) {
		conectar();
		
		Cliente cliente = new Cliente();
		
		PreparedStatement ps;
		
		try {
			ps = miConexion.prepareStatement(ConstantesSQL.OBTENER_CLIENTE_POR_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				cliente.setNombre(rs.getString("nombre"));
				cliente.setCalle(rs.getString("calle"));
				cliente.setNumeracion(rs.getString("numeracion"));
				cliente.setCodigo_postal(rs.getString("codigo_postal"));
				cliente.setPoblacion(rs.getString("poblacion"));
				cliente.setTelefono(rs.getString("telefono"));
				cliente.setEmail(rs.getString("email"));
				cliente.setParticula_empresa(rs.getString("particula_empresa"));
				cliente.setId(id);				
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println("ERROR!! en la SQL");
			System.out.println(e.getMessage());
		}
		desconectar();	
		
		return cliente;
	}

	@Override
	public void guardarCambiosCliente(Cliente cliente) {
		conectar();
		PreparedStatement ps;
		try {
			ps = miConexion.prepareStatement(ConstantesSQL.GUARDAR_CAMBIOS_CLIENTE);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getCalle());
			ps.setString(3, cliente.getNumeracion());
			ps.setString(4, cliente.getCodigo_postal());
			ps.setString(5, cliente.getPoblacion());
			ps.setString(6, cliente.getTelefono());
			ps.setString(7, cliente.getEmail());
			ps.setString(8, cliente.getParticula_empresa());
			ps.setInt(9,cliente.getId());
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR!! en la SQL de guardar cambios este mal");
			System.out.println(e.getMessage());
		}

		desconectar();	
	}
		

	@Override
	public void registrarClientes(Cliente cliente) {
		conectar();
		try {
		
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.INSERCION_CLIENTE);
			ps.setString(1, cliente.getNombre());	
			ps.setString(2, cliente.getCalle());
			ps.setString(3, cliente.getNumeracion());
			ps.setString(4, cliente.getCodigo_postal());
			ps.setString(5, cliente.getPoblacion());
			ps.setString(6, cliente.getTelefono());
			ps.setString(7, cliente.getEmail());
			ps.setString(8, cliente.getParticula_empresa());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("ERROR!! la SQL de insercion de cliente esta mal");
			System.out.println(e.getMessage());
		}
		desconectar();
		
	}

	@Override
	public void borrarCliente1(int id) {
		conectar();
		
		PreparedStatement ps;
		try {
			ps = miConexion.prepareStatement(ConstantesSQL.BORRAR_CLIENTE);
			
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
	public void borrarCliente(int id) {
		conectar();
		
		PreparedStatement ps;
		try {
			ps = miConexion.prepareStatement(ConstantesSQL.BORRAR_CLIENTE);
			
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
}//END CLASS
