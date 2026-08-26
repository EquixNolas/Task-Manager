package dao;

import java.util.List;

import entities.Proyecto;
import entities.Usuario;

public interface IProyectoDao extends IGenericDao<Proyecto, Long>{
	boolean addMember(Long proyectoId, Long usuarioId);
	boolean removeMember(Long proyectoId, Long usuarioId);
	List<Proyecto> findByOwner(Long ownerId); //MIS PROYECTOS
	List<Proyecto> findByMember(Long userId); //COMPARTIDOS CONMIGO
	List<Proyecto> findActiveProjects();
}
