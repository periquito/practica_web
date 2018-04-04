package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.http.Part;

import daos.PrendaDAO;
import daosImpl.PrendaDAOImpl;
import modelo.Prenda;


@WebServlet("/ServletGuardarCambiosPrenda")
public class ServletGuardarCambiosPrenda extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String articulo = request.getParameter("campoArticulo");
		String color = request.getParameter("campoColor");
		String detalles = request.getParameter("campoDetalles");
		String unidades = request.getParameter("campoUnidades");
		String talla = request.getParameter("campoTalla");
		String precio = request.getParameter("campoPrecio");
		String tipo_material = request.getParameter("campoTipo_material");
		String id = request.getParameter("campoId");
		Part imagen = request.getPart("campoImagen");
		
		//ahora deberiamos validar todos los datos
		//...........
		//fin parte validar
		
		Prenda prenda = new Prenda(articulo, color, detalles, unidades, talla, precio, tipo_material,imagen );
		prenda.setId(Integer.parseInt(id));
		
		PrendaDAO prendaDAO = new PrendaDAOImpl();
		prendaDAO.guardarCambiosPrenda(prenda);
		request.getRequestDispatcher("ServletListadoPrenda").forward(request, response);
		
	}

}
