<%@page import="beans.Libro"%>
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
<%List<Libro> libros = (List<Libro>) request.getAttribute("libros"); %>

<table border="1">
			<tr>
				<th>ISBN</th><th>TITULO</th><th>AUTOR</th><th>PRECIO</th><th>PAGINAS</th>
			</tr>
			<%for(Libro c: libros){ %>
				<tr>
					<td><%=c.getIsbn() %></td>
					<td><%=c.getTitulo() %></td>
					<td><%=c.getAutor() %></td>
					<td><%=c.getPrecio() %></td>
					<td><%=c.getPaginas() %></td>
				</tr>
			
			<%} %>
		
		</table>
			
	
	<br/>
	<a href="ListadoTemasAction">Volver</a>

</center>
</body>
</html>