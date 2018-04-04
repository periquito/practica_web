package servlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


@WebServlet("/ServletRegistroCliente")
public class ServletRegistroCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//protegemos este servlet por si se intenta acceder a el directamente
		//sin estar identificado
		
		if(request.getSession().getAttribute("admin")== null){
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
	
		}
		System.out.println("Se ejecuta el Post del ServletRegistroAnuncio");
		
		//recoger lo que ha introducido el usuario en el formulario:
		//CampoTitulo es el name del input del que quiero coger la informacion
		String nombre = request.getParameter("campoNombre");
		String calle = request.getParameter("campoCalle");
		String numeracion = request.getParameter("campoNumeracion");
		String codigo_postal = request.getParameter("campoCodigo_postal");
		String poblacion = request.getParameter("campoPoblacion");
		String telefono = request.getParameter("campoTelefono");
		String email = request.getParameter("campoEmail");
		String particula_empresa = request.getParameter("campoParticula_empresa");
		
		//Parte de validacion de datos
		
		//Fin parte de validacion de datos
		
		Cliente nuevoCliente = new Cliente(nombre, calle, numeracion, codigo_postal, poblacion, telefono, email, particula_empresa);
	
		//ahora le damos el nuevo anuncio a un dao para que lo resgistre
		System.out.println("vamos aregistar: " + nuevoCliente.toString());
		ClienteDAO clienteDAO = new ClienteDAOImpl();		
		clienteDAO.registrarClientes(nuevoCliente);
		
		//DEsde un servlet no deberia mostrale nada al usuarip, para eso
		//tenemos las jsp que son las encargadas de realizar la "vista"
		//de la aplicacion
		
		
		//Asi digo al servlet que siga la ejecucion en la siguiente JSP
		request.getRequestDispatcher("registroClienteOK.jsp").forward(request, response);
		
	}//end doPost

}//end class
