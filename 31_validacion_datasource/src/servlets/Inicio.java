package servlets;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Cliente;
import modelo.GestionClientes;

/**
 * Servlet implementation class Inicio
 */
@WebServlet("/Inicio")
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recuperamos la contraseña y el valor de la casilla de recordar
		String pass = request.getParameter("pass");
		String user = request.getParameter("usuario");
		RequestDispatcher rd;
		GestionClientes gClientes = new GestionClientes();
		

		if(gClientes.estaRegistrado(user, pass)) {	//Está registrado

			String valorCookie="";
			if(request.getParameter("recordar")!=null) {
				valorCookie=request.getParameter("usuario");
			}
			guardarCookie(valorCookie,response);
			
			//Recuperamos la sesion
			HttpSession sesion = request.getSession();
			//Incorporamos el atributo nombre a la sesion con el parametro usuario que viene de la peticion
			sesion.setAttribute("nombre", request.getParameter("usuario"));
			
			// Indicamos siguiente servlet/html de destino
			rd = request.getRequestDispatcher("ListadoTemasAction");

		}else {//No esta registrado
			
			// Indicamos siguiente servlet/html de destino
			rd = request.getRequestDispatcher("error.jsp");
		}
		
		
		
		// Transferimos la peticion hacia el siguiente servlet/html
		rd.forward(request, response);
	}
	
	
	private void guardarCookie(String valor, HttpServletResponse resp) {
		Cookie ck=new Cookie("user",valor);
		ck.setMaxAge(200000);
		resp.addCookie(ck);
	}

}
