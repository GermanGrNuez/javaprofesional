package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import beans.Tema;

public class GestionTemas {
	
	DataSource ds;
	
	public GestionTemas() {
		//Carga del driver
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/reftemas");		
		} catch (NamingException e) {
			e.printStackTrace();
		}	
	}
	
	
	public List<Tema> recuperarTemas() {
	     
        List<Tema> lista=new ArrayList<> ();           
        try(Connection cn = ds.getConnection();) {                       
            String sql="select * from temas";
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);            
            while(rs.next()){
                lista.add(new Tema(rs.getInt("idTema"),rs.getString("tema")));
            }
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }   
        return lista;
	}
	

	
}
