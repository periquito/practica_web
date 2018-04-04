<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<jsp:include page="menu.jsp"></jsp:include>

<form action ="ServletGuardarCambiosPrenda" method = "post">
	articulo: <input type = "text" name = "campoArticulo" value="${prendaAeditar.articulo}"/><br/>
	color: <input type = "text" name="campoColor" value="${prendaAeditar.color}"/><br/>	
	detalles: <input type = "text" name = "campoDetalles" value="${prendaAeditar.detalles}"/><br/>
	
	<input type ="hidden" name ="campoId" value="${prendaAeditar.id}"/>
	
	unidades: <input type = "text" name="campoUnidades" value="${prendaAeditar.unidades}"/><br/>
	talla: <input type = "text" name = "campoTalla" value="${prendaAeditar.talla}"/><br/>
	precio: <input type = "text" name="campoPrecio" value="${prendaAeditar.precio}"/><br/>	
	tipo_material: <input type = "text" name = "campoTipo_material" value="${prendaAeditar.tipo_material}"/><br/>

	<br/>
	<input type = "submit" value ="GUARDAR CAMBIOS"/>	
</form>

</body>
</html>