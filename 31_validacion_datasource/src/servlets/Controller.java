package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("op");
		String url="";
		switch(op) {
			case "doAltaCliente":
				url="AltaClienteAction";
				break;
			case "doIsRegistrado":
				url="IsRegistradoAction";
				break;		
			case "doVerLibrosTema":
				url="LibrosAction";
				break;		
			case "toInicio":
				url="index.jsp";
				break;
			case "toRegistro":
				url="registrocliente.jsp";
				break;

		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
