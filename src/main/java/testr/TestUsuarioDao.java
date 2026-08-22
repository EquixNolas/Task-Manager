package testr;

import java.time.LocalDateTime;

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
		//altaUsuario();
		eliminarUsuario(7L);
		leerTodos();
		//System.out.println(udao.findById(4L));
	}
	
	public static void leerTodos() {
		for(Usuario e : udao.findAll()) {
			System.out.println(e);
		}
	}
	
	public static void altaUsuario() {
		Usuario usuario =  new Usuario(
				null, 
				"Palomita", 
				"Carolingia", 
				null, 
				"amsdmasdm", 
				"palo@correo.com", 
				LocalDateTime.of(2026, 11, 03, 11, 47) );
		udao.insertOne(usuario);
	}
	
	public static void eliminarUsuario(Long id) {
		switch (udao.deleteOne(id)) {
		case 1: System.out.println("ELIMINANDO...");break;
		case 2: System.out.println("Usuario no existe"); break;
		case -1:System.out.println("Es imposible");
	
			
			break;

		default:
			break;
		}
		
	}
}
