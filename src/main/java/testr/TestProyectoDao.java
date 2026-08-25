package testr;

import dao.IProyectoDao;
import dao.IUsuarioDao;
import dao.ProyectoDaoImpl;
import dao.UsuarioDaoImpl;
import entities.Proyecto;
import entities.Usuario;

public class TestProyectoDao {

	private static IProyectoDao pdao;
	private static IUsuarioDao udao;
	
	static {
		pdao = new ProyectoDaoImpl();
		udao = new UsuarioDaoImpl();
	}
	
	public static void main(String[] args) {
		
		insertOnUsuarioProyecto(1L, 1L);
		leerTodos();
		//crearProyecto();
		//eliminarProyecto(14L);
		//modificarProyecto();
		//leerTodos();
		//System.out.println(udao.findById(4L));
	}
	
	public static void leerTodos() {
		for (Proyecto p : pdao.findAll()) {
			System.out.println(p);
		}
	}
	
	public static void insertOnUsuarioProyecto(Long usuarioId, Long proyectoId) {
		Usuario usuario = udao.findById(usuarioId);
		Proyecto proyecto = pdao.findById(proyectoId);
		
		proyecto.getUsuarios().add(usuario);
		
		pdao.updateOne(proyecto);
		System.out.println(proyecto);
	}

}
