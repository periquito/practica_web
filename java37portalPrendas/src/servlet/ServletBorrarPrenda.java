package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import daos.PrendaDAO;

import daosImpl.PrendaDAOImpl;


@WebServlet("/ServletBorrarPrenda")
public class ServletBorrarPrenda extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("borrar prenda de id: "+ id);
		PrendaDAO prendaDAO = new PrendaDAOImpl();
		
		prendaDAO.borrarPrenda(id);
		
		request.setAttribute("prendas", prendaDAO.obtenerPrenda());
		request.getRequestDispatcher("ServletListadoPrenda").forward(request, response);
	}

}
