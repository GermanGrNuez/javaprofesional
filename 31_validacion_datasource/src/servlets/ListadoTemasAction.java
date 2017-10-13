package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Tema;
import modelo.GestionTemas;

/**
 * Servlet implementation class ListadoTemasAction
 */
@WebServlet("/ListadoTemasAction")
public class ListadoTemasAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		GestionTemas gTemas = new GestionTemas();
		List<Tema> temas = gTemas.recuperarTemas();
		if(temas==null||temas.isEmpty()) {
			request.getRequestDispatcher("sincontactos.jsp").forward(request, response);
		}
		//guardamos la lista de contactos en un atributo de petición
		//para que sea accesible por la página JSP
		request.setAttribute("temas", temas);
		request.getRequestDispatcher("temas.jsp").forward(request, response);
			
	}

}
