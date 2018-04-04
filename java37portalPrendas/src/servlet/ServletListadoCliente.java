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

@WebServlet("/ServletListadoCliente")
public class ServletListadoCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		ClienteDAO daoCliente = new ClienteDAOImpl();
		//Asi continuo en listadoAnuncio.jsp, al cual le tengo que dar
		//los anuncios que me de el dao
		
		request.setAttribute("clientes", daoCliente.obtenerCliente());
		request.getRequestDispatcher("gestionClientes.jsp").forward(request, response);
		
		
		
	}//END doGet
}//END Class
