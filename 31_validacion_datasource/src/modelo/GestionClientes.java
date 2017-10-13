package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import beans.Cliente;

public class GestionClientes {

	DataSource ds;
	
	public GestionClientes() {
		//Carga del driver
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/refclientes");		
		} catch (NamingException e) {
			e.printStackTrace();
		}	
	}
	
	
	public boolean estaRegistrado(String user, String pass) {
		boolean res=false;
		try(Connection con = ds.getConnection()){
			//definimos la instrucción SQL y la enviamos a través del objeto Statement
			String sql="select * from clientes where usuario=? and password=?";
			//Construimos la PreparedStatement
			PreparedStatement st=con.prepareStatement(sql);
			//Incluimos los parametros de la consulta
			st.setString(1, user);
			st.setString(2, pass);		

			//Ejecutamos la consulta y Recuperamos el resultado
			ResultSet rs = st.executeQuery();			
			if(rs.next()) {
				res=true;	
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return res;
	}
	
	public void registrar(Cliente c) {
		try(Connection cn = ds.getConnection()){
			 String sql="Insert into clientes (usuario,password,email,telefono) values(?,?,?,?)";
			 //creamos consulta preparada:
			 PreparedStatement ps=cn.prepareStatement(sql);
			 //Sustituimos parametros por valores
			 ps.setString(1, c.getNombre());
			 ps.setString(2, c.getPassword());
			 ps.setString(3, c.getEmail());
			 ps.setInt(4, c.getTelefono());
			 //ejecutamos
			 ps.execute();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		
	}
	
}
