package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Libro;
import modelo.GestionLibros;

/**
 * Servlet implementation class LibrosAction
 */
@WebServlet("/LibrosAction")
public class LibrosAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionLibros gLibros = new GestionLibros();
		List<Libro> libros;
		int opLibro = Integer.parseInt(request.getParameter("tema"));
		if(opLibro==0) {
			libros = gLibros.recuperarLibros();
		}else {
			libros = gLibros.recuperarLibros(opLibro);
		}
		request.setAttribute("libros", libros);
		request.getRequestDispatcher("libros.jsp").forward(request, response);
	}

}
