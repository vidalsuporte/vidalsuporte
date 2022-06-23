package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import modelo.BeanUserTelefone;
import modelo.TelefoneUser;
import modelo.Userposjava;

public class UserPosDAO {
 private Connection connection;
 
 	public UserPosDAO() {
 		
 		connection = SingleConnection.getConnection();
 	}
	
	public void salvar (Userposjava userposjava) {
		
		try {
		String sql = "insert into userposjava (nome, email) values (?, ?)";
		PreparedStatement insert = connection.prepareStatement(sql);
		insert.setString(1, userposjava.getNome());
		insert.setString(2, userposjava.getEmail());
		insert.execute();
		connection.commit();//Salva no Banco
			
		}catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				e.printStackTrace();
		
		}
	}
	
     public void salvarTelefone (TelefoneUser telefone) {
		
		try {
		String sql = "INSERT INTO public.telefoneuser(numero, tipo, usuariopessoa) VALUES (?, ?, ?);";
		PreparedStatement insert = connection.prepareStatement(sql);
		insert.setString(1, telefone.getNumero());
		insert.setString(2, telefone.getTipo());
		insert.setLong(3, telefone.getIdUserPosJava());
		insert.execute();
		connection.commit();//Salva no Banco
			
		}catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				e.printStackTrace();
		
		}
	}
	
	
	public List<Userposjava> listar() throws Exception{
		List<Userposjava> list = new ArrayList<Userposjava>();
		
		String sql = "select * from userposjava";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();
		
		
		while(resultado.next()) {
		Userposjava userposjava = new Userposjava();
		userposjava.setId(resultado.getLong("id"));
		userposjava.setNome(resultado.getString("nome"));
		userposjava.setEmail(resultado.getString("email"));
		
		list.add(userposjava);
		}
		
		return list;
	}
	
	public Userposjava buscar(Long id) throws Exception{
		Userposjava userpjava = new Userposjava();
		
		String sql = "select * from userposjava where id = " + id;
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();
		
		
		while(resultado.next()) {
		
		userpjava.setId(resultado.getLong("id"));
		userpjava.setNome(resultado.getString("nome"));
		userpjava.setEmail(resultado.getString("email"));
		
		}
		
		return userpjava;
	}
	
	public void atualizar( Userposjava userPosJava) {
		
		try {
			String sql = "update userposjava set nome = ? where id = " + userPosJava.getId();
			PreparedStatement atualizar = connection.prepareStatement(sql);
			atualizar.setString(1, userPosJava.getNome());
			atualizar.execute();
			connection.commit();//Salva no Banco
				
			}catch (Exception e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					e.printStackTrace();
			
			}
		
	}
	
	public void deletar(Long id) {
		try {
			String sql = "delete from userposjava where id = " + id;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
			connection.commit();			
			
		}catch(Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				e.printStackTrace();
		
		}
	}
	
	 public List <BeanUserTelefone> listaUserTel(Long id){
		 List <BeanUserTelefone> listBean = new ArrayList<BeanUserTelefone>();
		String sql;
	try {	 
		sql = " SELECT nome, email, numero from telefoneuser as fone ";
		sql += " inner join userposjava as userp ";
		sql += " on fone.usuariopessoa = userp.id ";
		sql += "where userp.id = "+ id;
		PreparedStatement statment = connection.prepareStatement(sql);
		
		ResultSet result = statment.executeQuery();
		
		
		while (result.next()) {
		BeanUserTelefone bean = new BeanUserTelefone();
		bean.setEmail(result.getString("email"));
		bean.setNome(result.getString("nome"));
		bean.setNumero(result.getString("numero"));
		
		listBean.add(bean);
		}
		
				
	}catch(Exception e) {
		try {
			connection.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			e.printStackTrace();
	
	} 
		 
		 return listBean;
	 }
	
	
	
	
	
}
