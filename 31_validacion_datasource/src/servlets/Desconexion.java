package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Desconexion
 */
@WebServlet("/Desconexion")
public class Desconexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
 

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//Recuperamos la sesion y la invalidamos
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
    

}
