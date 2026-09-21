package dao;

import java.util.List;

import entities.Estado;
import entities.Tarea;

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
	public List<Tarea> findByAssignee(Long usuarioId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tarea> findOverdueTasks(Long proyectoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tarea> findTasksDueToday() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean assignUser(Long tareaId, Long usuarioId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int countTaskByStatus(Long proyectoId, String status) {
		// TODO Auto-generated method stub
		return 0;
	}

}
