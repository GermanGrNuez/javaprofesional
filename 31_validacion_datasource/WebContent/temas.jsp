<%@page import="beans.Tema"%>
<%@page import="java.util.List"%>
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
<form action="Controller?op=doVerLibrosTema" method="post">
<%List<Tema> temas = (List<Tema>)request.getAttribute("temas");%>
	
			<select name="tema">
				<option value="0">Todos</option>
			<%for(Tema t:temas){ %>

				<option value="<%=t.getIdTema()%>"><%=t.getNombre() %></option>
			
			
			<%} %>
		</select>
	
	<input type="submit" value="Consultar">
	<br/>
	<a href="Controller?op=toInicio">Volver</a>
</form>

</center>

</body>
</html>