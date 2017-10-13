package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Cliente;
import modelo.GestionClientes;

/**
 * Servlet implementation class AltaClienteAction
 */
@WebServlet("/AltaClienteAction")
public class AltaClienteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionClientes gcontactos=new GestionClientes();
		gcontactos.registrar(new Cliente(request.getParameter("nombre"),  request.getParameter("email"), request.getParameter("pass"), Integer.parseInt(request.getParameter("telefono"))));
		
		request.getRequestDispatcher("index.jsp").forward(request, response);

		
		
	}

}
