package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Cliente;
import modelo.Prenda;
import daos.ClienteDAO;
import daos.PrendaDAO;
import daosImpl.ClienteDAOImpl;
import daosImpl.PrendaDAOImpl;


@WebServlet("/ServletEditarCliente")
public class ServletEditarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		ClienteDAO clientesDAO = new ClienteDAOImpl();
		
		Cliente aprendaAeditar = clientesDAO.obtenerClientePorId(id);
		
		request.setAttribute("clienteAeditar", aprendaAeditar);
		request.getRequestDispatcher("editarClientes.jsp").forward(request, response);
		
	}

}
