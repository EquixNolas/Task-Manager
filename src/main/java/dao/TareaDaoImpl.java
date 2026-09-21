package dao;

import java.util.List;

import org.eclipse.persistence.jpa.jpql.tools.model.EclipseLinkSelectExpressionStateObjectBuilder;

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

	@Override
	public List<Tarea> findTareas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tarea> findByProyecto(Long proyectoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tarea> findByProyectoAndStatus(Long proyectoId, String status) {
		// TODO Auto-generated method stub
		return null;
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
