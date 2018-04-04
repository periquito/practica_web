<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${sessionScope.admin == null}">
	<jsp:forward page="login.jsp"></jsp:forward>
</c:if>

<a href="ServletListadoPrenda">gestionar prenda</a>
<a href="registrarPrenda.jsp">registrar prenda</a>
<br/>
<a href="ServletListadoCliente">gestionar cliente</a>
<a href="registrarCliente.jsp">registrar cliente</a>
<br/>
<a href="ServletLogOut">salir</a>
<br/>

