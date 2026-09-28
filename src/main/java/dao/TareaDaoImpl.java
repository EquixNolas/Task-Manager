package dao;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import entities.Estado;
import entities.Proyecto;
import entities.Tarea;
import entities.Usuario;
import jakarta.persistence.TypedQuery;

public class TareaDaoImpl extends AbstractDaoImpl implements ITareaDao{

	@Override
	public int insertOne(Tarea entity) {
		try {
			tx.begin();
				em.persist(entity);
			tx.commit();
			return 1;
		} catch (Exception e) {
			System.err.println("Error critico en insertOne: "+e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int updateOne(Tarea entity) {
		try {
			if (findById(entity.getTareaId()) != null) {
				tx.begin();
					em.persist(entity);
				tx.commit();
				return 1;
			}else {
				return 0;
			}
		} catch (Exception e) {
			System.err.println("Error critico en updateOne: " + e.getMessage());
			e.getStackTrace();
			return -1;
		}
	}

	@Override
	public int deleteOne(Long valueId) {
		Tarea tarea = findById(valueId);
		try {
			if (tarea != null) {
				tx.begin();
					em.remove(tarea);
				tx.commit();
				return 1;
			}else {
				return 0;
			}
		} catch (Exception e) {
			System.err.println("Error critico en deleteOne: " + e.getMessage());
			e.getStackTrace();
			return -1;
		}
	}

	@Override
	public Tarea findById(Long valueId) {
		return em.find(Tarea.class, valueId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tarea> findAll() {
		jpql = "From Tarea t";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tarea> findByProyecto(Long proyectoId) {
		jpql = "FROM Tarea t WHERE t.proyecto.projectId = :Id";
		query = em.createQuery(jpql, Tarea.class);
		query.setParameter("Id", proyectoId);
		
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tarea> findByProyectoAndStatus(Long proyectoId, String status) {
		jpql = "FROM Tarea t WHERE t.proyecto.projectId = :Id AND t.estado = :status";
		query = em.createQuery(jpql, Tarea.class);
		query.setParameter("Id", proyectoId);
		
		try {
			//INSTANCIA DEL CONVERTIDOR
			converters.EstadoConverter converter = new converters.EstadoConverter();
			//Convertir String
			Estado estadoEnum = converter.convertToEntityAttribute(status);
			
			query.setParameter("status", estadoEnum);
			
			return query.getResultList();
			
		} catch (Exception e) {
			System.err.println("Error: El estado proporcionado " + status
								+ " no es válido. " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Tarea> findByAssignee(Long userId) {
		em.clear();
		
	    jpql = "SELECT t FROM Tarea t JOIN t.proyecto p JOIN p.members m WHERE m.userId = :userId";
	    
	    TypedQuery<Tarea> query = em.createQuery(jpql, Tarea.class);
	    query.setParameter("userId", userId);
	    
	    return query.getResultList();
	}


	@Override
	public List<Tarea> findOverdueTasks(Long proyectoId) {
		jpql = "FROM Tarea t "
				+ "WHERE t.proyecto.projectId = :proyectoId "
				+ "AND t.releaseDate < :actualDate "
				+ "AND t.estado != :stateFilter";
		
		TypedQuery<Tarea> query = em.createQuery(jpql, Tarea.class);

		query.setParameter("proyectoId", proyectoId);
		query.setParameter("actualDate", LocalDateTime.now());
		query.setParameter("stateFilter", Estado.Completada);
		
		return query.getResultList();
	}

	@Override
	public List<Tarea> findTasksDueToday() {
		LocalDateTime startToday = LocalDate.now().atStartOfDay();
		LocalDateTime endToday = LocalDate.now().atTime(LocalTime.MAX);
		
		jpql = "FROM Tarea t WHERE t.releaseDate BETWEEN :start AND :end";
		
		TypedQuery<Tarea> query = em.createQuery(jpql, Tarea.class);
		query.setParameter("start", startToday);
		query.setParameter("end", endToday);
		
		return query.getResultList();
	}

	@Override
	public boolean assignUser(Long tareaId, Long usuarioId) {
		try {
			Tarea tarea = findById(tareaId);
			if(tarea == null || tarea.getProyecto() == null)
				return false;
			
			Proyecto proyecto = tarea.getProyecto();
			
			Usuario usuario = em.find(Usuario.class, usuarioId);
			if(usuario == null)
				return false;
			
			proyecto.getMembers().add(usuario);

			em.merge(proyecto);
			
			return true;
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			return false;
		}
	}

	@Override
	public Long countTaskByStatus(Long proyectoId, String status) {
		 try {
		        jpql = "SELECT COUNT(t) FROM Tarea t WHERE t.estado = :estado";
		        TypedQuery<Long> query = em.createQuery(jpql, Long.class);
		        query.setParameter("estado", status);
		        return query.getSingleResult();
		        
		    } catch (Exception e) {
		        System.err.println("Error al contar tareas por estado: " + e.getMessage());
		        return 0L; 
		    }
	}

}
