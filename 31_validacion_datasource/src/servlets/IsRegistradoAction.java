package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.GestionClientes;

/**
 * Servlet implementation class IsRegistradoAction
 */
@WebServlet("/IsRegistradoAction")
public class IsRegistradoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IsRegistradoAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionClientes gClientes = new GestionClientes();
		gClientes.estaRegistrado(request.getAttribute("usuario").toString(), request.getAttribute("pass").toString());
		request.getRequestDispatcher("ListadoTemasAction").forward(request, response);
	}

}
