package testr;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
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
		
		//insertOnUsuarioProyecto(3L, 5L);
		//System.out.println(udao.findById(4L));
		
		//System.out.println("\n PRUEBA CRUD PROYECTO \n");
		//leerTodos();
		//crearProyecto();
		//modificarProyecto(15L);
		//eliminarProyecto(14L);
		
		/*
		System.out.println("\n PRUEBA ELIMINAR \n");
		System.out.println(pdao.findById(15L).getMembers().size());;
		eliminarMienbro();
		System.out.println(pdao.findById(15L).getMembers().size());;
		*/
		
		leerTodosMiembros();
		System.out.println("\n Lista de proyectos por busqueda | helper methods \n");
		//buscarPorOwner(6L);
		listarMiembros(5L);//ProyectoId 5 tiene 4 miembros
		listarMiembros(3L);//ProyectoId 3 tiene 2 miembros
		listarMiembros(1L);//ProyectoId 3 tiene 1 miembro
		listarMiembros(19L);//No existe
		
		//buscarPorMiembro(7L);
		
		System.out.println("\n------------FIN DE PROGRAMA------------");
	}
	
	public static void listarMiembros(Long	proyectoId) {
		Proyecto p = pdao.findById(proyectoId);
		if(p !=null) {
			System.out.println("Proyecto: "+p.getProjectId());
			Set<Usuario> u = p.getMembers();
			u.forEach(System.out::println);
		}
		else
			System.out.println("El proyecto "+proyectoId+" no se encontró");
	}
	
	public static void buscarPorMiembro(Long user) {
		List<Proyecto> proyectos = pdao.findByMember(user);
		if(proyectos.size() > 0)
			//Lambda que imprime linea por linea
			proyectos.forEach(System.out::println);
		else
			System.out.println("NO HAY PROYECTO ASOCIADO AL USUARIO: " +user+"L");
		
	}
	
	public static void buscarPorOwner(Long owner) {
		List<Proyecto> proyectos = pdao.findByOwner(owner);
		if(proyectos.size() > 0)
			//Lambda que imprime linea por linea
			proyectos.forEach(System.out::println);
		else
			System.out.println("NO HAY PROYECTO ASOCIADO AL USUARIO: " + owner+"L");
		
	}
	
	public static void addMienbros() {
		for (Usuario u : udao.findAll())
			pdao.addMember(15L, u.getUserId());

		System.out.println(pdao.findById(15L).getMembers().size());
	}
	
	public static void eliminarMienbro() {
		pdao.removeMember(15L, 3L);
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
	
	public static void leerTodosMiembros() {
		for (Proyecto p : pdao.findAll()) {
			p.getMembers().size();
			System.out.println("[ProjectId "+p.getProjectId()
			+", tittle "+p.getTittle()
			+", members "+p.getMembers().size()+"]");
		}
	}

	public static void insertOnUsuarioProyecto(Long usuarioId, Long proyectoId) {
		Proyecto proyecto = pdao.findById(proyectoId);
		Usuario usuario = udao.findById(usuarioId);
		proyecto.getMembers().add(usuario);
		pdao.updateOne(proyecto);
		System.out.println(proyecto);
	}
}