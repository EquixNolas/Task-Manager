package dao;


import java.util.List;

import entities.Tarea;

public interface ITareaDao extends IGenericDao<Tarea, Long>{
	List<Tarea> findTareas();
	List<Tarea> findByProyecto(Long proyectoId);
	List<Tarea> findByProyectoAndStatus(Long proyectoId, String status);
	List<Tarea> findByAssignee(Long usuarioId); // MIS TAREAS PENDIENTES
	
	//BUSCAR TAREAS ASSIGNADAS AL PROYECTO 
	//ANTERIOR A LA FECHA ACTUAL Y AUN NO ESTÉN COMPLETADAS
	List<Tarea> findOverdueTasks(Long proyectoId);
	List<Tarea> findTasksDueToday(); //Tareas que vencen hoy
	
	boolean assignUser(Long tareaId, Long usuarioId);
	int countTaskByStatus(Long proyectoId, String status);
}
