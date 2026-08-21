package testr;

import java.time.LocalDate;
import java.time.LocalDateTime;

import entities.Prioridad;
import entities.Proyecto;
import entities.Tarea;
import entities.Usuario;

public class test {

	public static void main(String[] args) {
		
		Usuario usuario1 = new Usuario(
				1L, 
				"Juan", 
				"Augusto", 
				"Remo", 
				"1LOo.d1m/NSAd61w#61Vn@8A", 
				"correo@correo.com", 
				LocalDateTime.of(2026, 8, 1, 6, 45)
				);
		
		Proyecto proyecto1 = new Proyecto(
				1L, 
				"Primer proyecto", 
				"descripcion proyecto", 
				LocalDateTime.of(2026, 8, 15, 15, 30), 
				LocalDateTime.of(2026, 9, 25, 10, 12), 
				usuario1);
				
		Tarea tarea = new Tarea(
				1L, 
				"prueba", 
				"descripcion de prueba", 
				LocalDateTime.of(2026, 8, 21, 10, 0), 
				LocalDateTime.of(2026, 8, 30, 23, 59),
				Prioridad.ALTA, 
				proyecto1);

		System.out.println(tarea.getProyecto().getDescription());
	}

}
