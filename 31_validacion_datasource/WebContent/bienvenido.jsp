<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.time.*, java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<%String nombre="";
		if(session.getAttribute("nombre") != null) {
			nombre = (String) session.getAttribute("nombre");	
		}%>
		
		<h1>Bienvenido<%=nombre%></h1>
		<h1>Has elegido el tema: <%=request.getParameter("tema") %></h1>
		</br>
		<%=LocalTime.now() %>
		<a href='Desconexion'>Desconectar</a>
	</center>
</body>
</html>