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


@WebServlet("/ServletBorrarCliente")
public class ServletBorrarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("borrar cliente de id: "+ id);
		ClienteDAO clienteDAO = new ClienteDAOImpl();
		
		clienteDAO.borrarCliente(id);
		
		request.setAttribute("clientes", clienteDAO.obtenerCliente());
		request.getRequestDispatcher("ServletListadoCliente").forward(request, response);
	}

}
