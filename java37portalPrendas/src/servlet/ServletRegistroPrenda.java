package servlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import javax.servlet.http.Part;

import daos.PrendaDAO;


import daosImpl.PrendaDAOImpl;
import modelo.Prenda;



@WebServlet("/ServletRegistroPrenda")
@MultipartConfig
public class ServletRegistroPrenda extends HttpServlet {
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
		String articulo = request.getParameter("campoArticulo");
		String color = request.getParameter("campoColor");
		String detalles = request.getParameter("campoDetalles");
		String unidades = request.getParameter("campoUnidades");
		String talla = request.getParameter("campoTalla");
		System.out.println("campo precio: " + request.getParameter("campoPrecio"));
		String precio = request.getParameter("campoPrecio").replaceAll(",",".");
		String tipo_material = request.getParameter("campoTipo_material");
		Part imagen = request.getPart("campoImagen");
		
		
		//Parte de validacion de datos
		
		if(!this.validarDatos(request, response, "[a-zA-Z·ÈÌÛ˙Ò—\\s]{3,10}", articulo, "ARTICULO")){			
			return;
		}
		
		if(!this.validarDatos(request, response, "[a-zA-Z·ÈÌÛ˙Ò—\\s]{3,10}", color, "COLOR")){			
			return;
		}
		
		if(!this.validarDatos(request, response, "[a-zA-Z·ÈÌÛ˙Ò—\\s]{3,10}", tipo_material, "TIPO DE MATERIAL")){			
			return;
		}
		
		if(!this.validarDatos(request, response, "[a-zA-Z·ÈÌÛ˙Ò—\\s]{3,10}", detalles, "DETALLES")){			
			return;
		}
		
		if(!this.validarDatos(request, response, "[0-9]{1,4}", unidades, "UNIDADES")){			
			return;
		}
		
		if(!this.validarDatos(request, response, "[0-9]+([,.][0-9]{1,2})?", precio, "PRECIO")){			
			return;
		}
		//Fin parte de validacion de datos
	
		Prenda nuevoPrenda = new Prenda(articulo, color, detalles, unidades, talla, precio, tipo_material, imagen);
		//ahora le damos el nuevo anuncio a un dao para que lo resgistre
		System.out.println("vamos aregistar: " + nuevoPrenda.toString());
		PrendaDAO prendaDAO = new PrendaDAOImpl();		
		prendaDAO.registarPrenda(nuevoPrenda);
		
		
		//DEsde un servlet no deberia mostrale nada al usuarip, para eso
		//tenemos las jsp que son las encargadas de realizar la "vista"
		//de la aplicacion
		
		
		//Asi digo al servlet que siga la ejecucion en la siguiente JSP
		request.getRequestDispatcher("registroPrendaOK.jsp").forward(request, response);
		
	}//end doPost
	
	private boolean validarDatos(HttpServletRequest request, HttpServletResponse response, String expReg, String dato, String nombreParametro) throws ServletException, IOException{
		Pattern patten = Pattern.compile(expReg);
		Matcher macher = patten.matcher(dato);		
		
		if(macher.matches()){
			System.out.println(nombreParametro + " OK");
			return true;
		}else {
			
			System.out.println(nombreParametro+" ERROR");
			request.setAttribute("mensaje", nombreParametro+": no valido");
			request.getRequestDispatcher("registrarPrenda.jsp").forward(request, response);
			return false;
		}
	}
}//end class
