//ojo hay que hacer cosas
package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.AdministradorDAO;
import daos.PrendaDAO;
import daosImpl.AdministradorDAOImpl;
import daosImpl.ClienteDAOImpl;

@WebServlet("/ServletIdentificacionAdmin")
public class ServletIdentificacionAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Se ejecuta el servlet de identificacion de admin");

		String login = request.getParameter("campoLogin");
		String pass = request.getParameter("campoPass");
		System.out.println("login: " + login + " pass:" + pass);
		AdministradorDAO administradorDAO = new AdministradorDAOImpl();
		if (administradorDAO.identificarAdmin(login, pass)) {
			System.out.println("login ok");
			request.getSession().setAttribute("admin", "ok");
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);

		} else {
			System.out
					.println("login o pass incorrectos " + login + " " + pass);
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
		}
	}// end service

}
