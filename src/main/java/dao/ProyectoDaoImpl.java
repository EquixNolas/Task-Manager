package dao;

import java.util.List;

import entities.Proyecto;

public class ProyectoDaoImpl extends AbstractDaoImpl implements IProyectoDao{

	@Override
	public int insertOne(Proyecto entity) {
		try {
			tx.begin();
				em.persist(entity);
			tx.commit();
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

	@Override
	public int updateOne(Proyecto entity) {
		try {
			if(findById(entity.getProjectId()) != null) {
				tx.begin();
					em.persist(entity);
				tx.commit();
				return 1;
			}
			else {
				return 0;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return -1;
		}
	}

	@Override
	public int deleteOne(Long valueId) {
		Proyecto proyecto = findById(valueId);
		try {
			if(proyecto != null) {
				tx.begin();
					em.remove(proyecto);
				tx.commit();
				return 1;
			}
			else {
				return 0;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return -1;
		}
	}

	@Override
	public Proyecto findById(Long valueId) {
		return em.find(Proyecto.class, valueId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> findAll() {
		jpql = "FROM Proyecto p";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

}
