package pos_java_jdbc.pos_java_jdbc;

import java.util.List;

import org.junit.Test;
import dao.UserPosDAO;
import modelo.BeanUserTelefone;
import modelo.TelefoneUser;
import modelo.Userposjava;

public class TesteJdbc {

	@Test
	public void whileTest() {
		int x = 0;
		
		while(x <=18) {
			x = x +3;
		}
		System.out.println(x);
		
	}
	@Test
	public void initBanco() {
		
		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userposjava = new Userposjava();
		
		userposjava.setNome("José");
		userposjava.setEmail("jose@gmail.com");
		
		userPosDAO.salvar(userposjava);
		
		
	}
	
	
	@Test
	public void initListar() {
		
		UserPosDAO dao = new UserPosDAO();
		
		try {
			
			List<Userposjava> list = dao.listar();
			
				for(Userposjava userposjava : list) {
					System.out.println(userposjava);
					System.out.println("-------------------------------");
				}
			
			
		} catch ( Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void initBuscar() {
		
			UserPosDAO dao = new UserPosDAO();
			Userposjava user = new Userposjava();
			
			user.setId(5L);
			try {
				user = dao.buscar(user.getId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(user);
			
			
		                                                                                                 
	}
	@Test
	public void initAtualizar() {
		
		try {

	
		UserPosDAO dao = new UserPosDAO();
		Userposjava objetoDoBanco = new Userposjava();
		objetoDoBanco.setId(5L);
		objetoDoBanco.setNome("nome trocado");
		dao.atualizar(objetoDoBanco);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void initDelete() {
		
		try {
			UserPosDAO dao = new UserPosDAO();
			dao.deletar(5L);	
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void initInsertTelefone() {
		
		TelefoneUser telefone = new TelefoneUser();
		telefone.setNumero("(87) 4445-4545");
		telefone.setTipo("casa");
		telefone.setIdUserPosJava(7L);
		
		
		UserPosDAO dao = new UserPosDAO();
		dao.salvarTelefone(telefone);
		
	}
	
	
	@Test
	public void initListarTelefone() {
	
	
	
	}
	
	@Test
	public void initListarUserTel() {
	
		
		UserPosDAO dao = new UserPosDAO();
		List<BeanUserTelefone> beanU = dao.listaUserTel(7L);
		for (BeanUserTelefone beanUserTelefone : beanU) {
		System.out.println(beanUserTelefone);
		System.out.println("_________________");
			
		}
		
		
	}
	
}
