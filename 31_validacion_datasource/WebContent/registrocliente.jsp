<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
	<form action="Controller?op=doAltaCliente" method="post">
		Nombre: <input type="text" name="nombre"/></br>
		Email: <input type="text" name="email"/></br>
		Contrase�a: <input type="password" name="pass"/></br>
		Telefono: <input type="number" name="telefono"/></br>
		<input type="submit" value="Guardar"/>
	
	
	</form>

</center>
</body>
</html>