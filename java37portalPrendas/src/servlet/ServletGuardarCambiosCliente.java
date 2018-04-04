package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import daos.ClienteDAO;
import daos.PrendaDAO;
import daosImpl.ClienteDAOImpl;
import daosImpl.PrendaDAOImpl;
import modelo.Cliente;
import modelo.Prenda;


@WebServlet("/ServletGuardarCambiosCliente")
public class ServletGuardarCambiosCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String nombre = request.getParameter("campoNombre");
		String calle = request.getParameter("campoCalle");
		String numeracion = request.getParameter("campoNumeracion");
		String codigo_postal = request.getParameter("campoCodigo_postal");
		String poblacion = request.getParameter("campoPoblacion");
		String telefono = request.getParameter("campoTelefono");
		String email = request.getParameter("campoEmail");
		String particula_empresa = request.getParameter("particula_empresa");
		String id = request.getParameter("campoId");
		
		//ahora deberiamos validar todos los datos
		//...........
		//fin parte validar
		
		Cliente cliente = new Cliente (nombre, calle, numeracion, codigo_postal, poblacion, telefono, email, particula_empresa);
		cliente.setId(Integer.parseInt(id));
		
		ClienteDAO clienteDAO = new ClienteDAOImpl();
		clienteDAO.guardarCambiosCliente(cliente);
		request.getRequestDispatcher("ServletListadoCliente").forward(request, response);
		
	}

}
