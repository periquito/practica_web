<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="menu.jsp"></jsp:include>

<c:forEach items="${prendas}" var="prenda">
<div style = "margin: 8px">
	articulo: ${prenda.articulo}<br/> 
	color: ${prenda.color} <br/> 
	detalles: ${prenda.detalles}<br/>  
	unidades: ${prenda.unidades} <br/> 
	talla: ${prenda.talla}<br/> 
	precio: ${prenda.precio} <br/> 
	tipo_material: ${prenda.tipo_material}<br/> 
	<img src= "${prenda.rutaImagen}" height = "200"><br/> 
	
	<a href = "ServletBorrarPrenda?id=${prenda.id}">BORRAR</a>
	<a href = "ServletEditarPrenda?id=${prenda.id}">EDITAR</a>
</div>
</c:forEach>
</body>
</html>