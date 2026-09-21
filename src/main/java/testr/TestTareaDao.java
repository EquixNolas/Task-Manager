package testr;

import java.time.LocalDateTime;
import java.util.List;

import dao.IProyectoDao;
import dao.ITareaDao;
import dao.ProyectoDaoImpl;
import dao.TareaDaoImpl;
import entities.Estado;
import entities.Prioridad;
import entities.Proyecto;
import entities.Tarea;

public class TestTareaDao {

	private static ITareaDao tdao;
	private static IProyectoDao pdao;
	
	static {
		tdao = new TareaDaoImpl();
		pdao = new ProyectoDaoImpl();
	}
	
	public static void main(String[] args) {
		//findById(7L);
		
		//System.out.println("\n LISTAR TODOS\n");
		//listarTodos();
		
		//System.out.println("\n CRUDTAREA\n");
		//crearTarea();
		//modificarTarea(15L);
		//eliminarTarea(15L);
		
		System.out.println("\n FindBy \n");
		//buscarPorProyecto(1L);
		buscarPorProyectoYEstado(1L, "En Progreso");
	}
	//Busqueda por Proyecto y estado
	public static void buscarPorProyectoYEstado(Long proyectoId, String status) {
		tdao.findByProyectoAndStatus(proyectoId, status).forEach(System.out::println);
	}
	//busqueda por proyecto asociado
	public static void buscarPorProyecto(Long proyectoId) {
		//System.out.println(tdao.findByProyecto(proyectoId));
		tdao.findByProyecto(proyectoId).forEach(System.out::println);
	}
	
	//Crear Tarea Con el ID 15
	public static void crearTarea() {
		Proyecto p = pdao.findById(2L);
		
		Tarea t = new Tarea(
				15L, 
				"Titulo Prueba tarea", 
				"Descripcion prueba", 
				LocalDateTime.now(), 
				LocalDateTime.of(2027, 1, 1, 0, 15), 
				Estado.En_progreso, 
				Prioridad.Baja, 
				p, 
				null);
		tdao.insertOne(t);
	}
	
	//Modificar Tarea
	public static void modificarTarea(Long tareaId) {
		Tarea t = tdao.findById(tareaId);
		if (t != null) {
			t.setTittle("Nuevo titulo de la tarea");
			System.out.println(tdao.updateOne(t));
		}
		else {
			System.out.println("Esta tarea no existe");
		}
	}
	
	//Eliminar Tarea
	public static void eliminarTarea(Long tareaId) {
		switch (tdao.deleteOne(tareaId)) {
			case 1: System.out.println("Eliminando..."); break;
			case 0:	System.out.println("la tarea no existe..."); break;
			case -1: System.out.println("No se puede eliminar la tarea..."); break;
				default: System.out.println("Es imposible de realizar");
		}
	}
	public static void findById(Long Id) {
		System.out.println(tdao.findById(Id));
	}
	
	public static void listarTodos() {
		tdao.findAll().forEach(System.out::println);
	}
}
