package testr;

import dao.IProyectoDao;
import dao.ProyectoDaoImpl;
import entities.Proyecto;

public class TestProyectoDao {

	private static IProyectoDao pdao;
	
	static {
		pdao = new ProyectoDaoImpl();
	}
	
	public static void main(String[] args) {
		leerTodos();
		//crearProyecto();
		//eliminarProyecto(14L);
		//modificarProyecto();
		//leerTodos();
		//System.out.println(udao.findById(4L));
	}
	
	public static void leerTodos() {
		for (Proyecto p : pdao.findAll())
			System.out.println(p);
	}
	

}
