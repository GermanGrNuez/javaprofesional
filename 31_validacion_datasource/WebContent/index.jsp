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
		<form action="Inicio" method="post">
		<%
			//Recuperar la cookie
			String nombre="";
			Cookie[] cks = request.getCookies();
			if(cks!= null){
				for(Cookie ck : cks){
					if(ck.getName().equals("nombre")){
						nombre = ck.getValue();
					}
				}
			}
		%>

			Usuario:<input type="text" name="usuario" value="<%=nombre%>"></br></br>
			Contraseña:<input type="password" name="pass"></br></br>
			<input type="submit" value="Entrar"></br>
			<input type="checkbox" name="recordar" value="1"/>Recordar</br>
			
			<a href="Controller?op=toRegistro">Registrarse</a>
			
		</form>
	</center>
</body>
</html>