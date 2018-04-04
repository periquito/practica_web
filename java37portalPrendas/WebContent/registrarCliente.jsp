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
Introduce los datos de tu cliente: <br/>


<form action= "ServletRegistroCliente" method = "post">
	nombre: <input type = "text" name = "campoNombre"/><br/>
	calle: <input type = "text" name = "campoCalle"/><br/>
	numeracion:	<input type = "text" name = "campoNumeracion"/><br/>
	codigo_postal: <input type = "text" name = "campoCodigo_postal"/><br/>
	poblacion: <input type = "text" name = "campoPoblacion"/><br/>
	telefono: <input type = "text" name = "campoTelefono"/><br/>
	email: <input type = "text" name = "campoEmail"/><br/>
	particula_empresa: <input type = "text" name = "campoParticula_empresa"/><br/>
	
	
	<input type = "submit" value ="ACEPTAR"/>

</form>

<script type = "text/javascript" src = "js/validacionRegistrarPrendaCliente.js"/></script>

</body>
</html>