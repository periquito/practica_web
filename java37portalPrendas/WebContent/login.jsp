<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


Introduce tus datos de administrador:<br/>

<form action="ServletIdentificacionAdmin" method ="post">
	login: 		<input type ="text" value="maria@gmail.com" name = "campoLogin"/><br/>
	pass: <input type ="password" value="123" name = "campoPass"/><br/>
	<input type = "submit" value = "IDENTIFICACION"/>
</form>
</body>
</html>