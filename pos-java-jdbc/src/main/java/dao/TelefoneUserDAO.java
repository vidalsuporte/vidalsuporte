package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexaojdbc.SingleConnection;
import modelo.TelefoneUser;

public class TelefoneUserDAO {

	private Connection connection;
	
public TelefoneUserDAO() {
 		
 		connection = SingleConnection.getConnection();
 	}
	
	public void salvar (TelefoneUser telUser) {
		
		
		try {
	    String sql = "INSERT INTO public.telefoneuser(numero, tipo, usuariopessoa) VALUES (?, ?, ?) ";
		PreparedStatement insert = connection.prepareStatement(sql);
		insert.setString(1, telUser.getNumero());
		insert.setString(2, telUser.getTipo());
		insert.setLong(3, telUser.getIdUserPosJava());
		insert.execute();
		connection.commit();
		
		
		
		}catch(Exception e) {
			try {
				connection.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
