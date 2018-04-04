package daos;

import java.util.List;





import modelo.Cliente;
import modelo.Prenda;


public interface ClienteDAO {
	

	void borrarCliente1 (int id);

	void registrarClientes(Cliente cliente);
	List<Cliente> obtenerCliente();
	void borrarCliente (int id);
	Cliente obtenerClientePorId(int id);
	void guardarCambiosCliente(Cliente cliente);

}
