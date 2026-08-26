package testr;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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
		
		//insertOnUsuarioProyecto(1L, 1L);
		//leerTodos();
		//crearProyecto();
		leerTodos();
		modificarProyecto(15L);
		System.out.println("\n DESPUES \n");
		leerTodos();
		//eliminarProyecto(14L);
		//System.out.println(udao.findById(4L));
	}
	public static void modificarProyecto(Long proyectoId) {
		Proyecto p = pdao.findById(proyectoId);
		if(p != null) {
			p.setDescription("Nueva Descripción");
			System.out.println(pdao.updateOne(p));
		}
		else
		{
			System.out.println("Este Proyecto No Existe");
		}
	}
	public static void crearProyecto() {
		Usuario u1 = udao.findById(2L);
		Set<Usuario> usuarios = new HashSet<Usuario>();
		usuarios.add(u1);
		Proyecto p = new Proyecto(
				8L, 
				u1, 
				usuarios, 
				"proyecto prueba",
				"descripcion prueba", 
				LocalDateTime.of(2024, 1, 14, 18, 13), 
				LocalDateTime.of(2027, 1, 1, 23, 59));
		pdao.insertOne(p);
	}
	public static void eliminarProyecto(Long proyectoId) {
		switch (pdao.deleteOne(proyectoId)) {
		case 1: System.out.println("ELIMINANDO...");break;
		case 2: System.out.println("Usuario no existe..."); break;
		case -1:System.out.println("No Se Puede Eliminar...");
			default: System.out.println("Es imposible de realizar");
		}
	}
	
	public static void leerTodos() {
		for (Proyecto p : pdao.findAll()) {
			System.out.println(p);
		}
	}
	
	public static void insertOnUsuarioProyecto(Long usuarioId, Long proyectoId) {
		//Proyecto proyecto = pdao.findById(proyectoId);
		//Usuario usuario = udao.findById(usuarioId);
		//proyecto.getUsuarios().add(usuario);
		//pdao.updateOne(proyecto);
		//System.out.println(proyecto);

		for (Proyecto p : pdao.findAll()) {
			Usuario usuario = udao.findById(p.getProjectId());
			p.getMembers().add(usuario);
			pdao.updateOne(p);
		}
	}
}
