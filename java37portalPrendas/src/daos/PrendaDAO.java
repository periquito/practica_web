package daos;

import java.util.List;

import modelo.Cliente;
import modelo.Prenda;

public interface PrendaDAO {
	
	void registarPrenda(Prenda prenda);
	
	List<Prenda> obtenerPrenda();
	
	void borrarPrenda (int id);

	Prenda obtenerPrendaPorId( int id);

	void guardarCambiosPrenda(Prenda prenda);

}
