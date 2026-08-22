package testr;

import dao.IUsuarioDao;
import dao.UsuarioDaoImpl;
import entities.Usuario;

public class TestUsuarioDao {

	private static IUsuarioDao udao;
	
	static {
		udao = new UsuarioDaoImpl();
	}
	public static void main(String[] args) {
		leerTodos();
	}
	
	public static void leerTodos() {
		for(Usuario e : udao.findAll()) {
			System.out.println(e);
		}
	}
	public static void altaUsuario() {
		Usuario usuario =  new Usuario();
		
		usuario.setUserId(null);
	}
}
