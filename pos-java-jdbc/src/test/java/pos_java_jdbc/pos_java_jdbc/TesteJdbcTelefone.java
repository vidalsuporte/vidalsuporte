package pos_java_jdbc.pos_java_jdbc;

import org.junit.Test;

import dao.TelefoneUserDAO;
import modelo.TelefoneUser;
import modelo.Userposjava;

public class TesteJdbcTelefone {

	@Test
	private void initInsert() {
		Userposjava userposjava = new Userposjava();
		TelefoneUser telefoneUser = new TelefoneUser();
		TelefoneUserDAO dao = new TelefoneUserDAO();
		userposjava.setId(5L);
		telefoneUser.setNumero("(32) 991203111");
		telefoneUser.setTipo("celular");
		dao.salvar(telefoneUser);
		
		
		
		
	}
	
	
	

}
