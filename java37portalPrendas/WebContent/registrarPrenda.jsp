<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<c:if test="${sessionScope.admin == null}">
	<jsp:forward page="login.jsp"></jsp:forward>
</c:if>

<div style = "color:red">${mensaje}</div>
<a href = "index.jsp">volver a inicio</a><br/>
Introduce los datos de tu prenda: <br/>



<form method="post" action= "ServletRegistroPrenda" 
enctype="multipart/form-data">
	articulo: <input type = "text" name = "campoArticulo"/><br/>
	color: <input type = "text" name = "campoColor"/><br/>
	detalles:	<input type = "text" name = "campoDetalles"/><br/>
	unidades: <input type = "text" name = "campoUnidades"/><br/>
	<!--talla:   <input type = "text" name = "campoTalla"/><br/>-->
	talla:   <select name="campoTalla">
				<option value="--">seleccione</option>
				<option value="S">S pequeña</option>
				<option value="M">M mediana</option>
				<option value="L">L grande</option>
				<option value="XL">XL extra grande</option>
			</select><br/>
	precio: <input type = "text" name = "campoPrecio"/><br/>
	tipo material: <input type = "text" name = "campoTipo_material"/><br/>
	imagen: <input type="file" name="campoImagen"/><br/>
	<input type = "submit" value ="ACEPTAR"/><br/>
	
	
</form>

<script type = "text/javascript" src = "js/validacionRegistrarAnuncioCliente.js"/></script>

</body>
</html>