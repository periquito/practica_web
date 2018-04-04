package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.PrendaDAO;
import daosImpl.PrendaDAOImpl;

@WebServlet("/ServletListadoPrenda")
public class ServletListadoPrenda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		PrendaDAO daoPrenda = new PrendaDAOImpl();
		//Asi continuo en listadoAnuncio.jsp, al cual le tengo que dar
		//los anuncios que me de el dao
		
		request.setAttribute("prendas", daoPrenda.obtenerPrenda());
		request.getRequestDispatcher("gestionPrendas.jsp").forward(request, response);
		
		
		
	}//END doGet
}//END Class
