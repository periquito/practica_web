package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Prenda;
import daos.PrendaDAO;
import daosImpl.PrendaDAOImpl;




@WebServlet("/ServletEditarPrenda")
public class ServletEditarPrenda extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		PrendaDAO prendasDAO = new PrendaDAOImpl();
		
		Prenda aprendaAeditar = prendasDAO.obtenerPrendaPorId(id);
		
		request.setAttribute("prendaAeditar", aprendaAeditar);
		request.getRequestDispatcher("editarPrendas.jsp").forward(request, response);
		
	}

}
