package dao;

import java.util.List;

import entities.Proyecto;
import entities.Usuario;

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

	@Override
	public boolean addMember(Long proyectoId, Long usuarioId) {
		Proyecto proyecto = em.find(Proyecto.class, proyectoId);
		Usuario usuario = em.find(Usuario.class, usuarioId);
		try {
			if (proyecto != null && usuario != null) {
				boolean added = proyecto.getMembers().add(usuario);
				
				if(added) {
					tx.begin();
						em.merge(proyecto);
					tx.commit();
					return true;
				}
			}
			
		} catch (Exception e) {
			if(tx != null && tx.isActive()) {
				tx.rollback();
			}
			System.err.println("Error critico en addMember: " + e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeMember(Long proyectoId, Long usuarioId) {
		Proyecto proyecto = em.find(Proyecto.class, proyectoId);
		Usuario usuario = em.find(Usuario.class, usuarioId);
		
		try {
			if (proyecto != null && usuario != null) {
				boolean removed = proyecto.getMembers().remove(usuario);
				
				if(removed) {
					tx.begin();
						em.merge(proyecto);
					tx.commit();
					return true;
				}
			}
			
		} catch (Exception e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			
			System.err.println("Error crítico en removeMember: " + e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Proyecto> findByOwner(Long ownerId) {
		jpql = "FROM ";
		return null;
	}

	@Override
	public List<Proyecto> findByMember(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proyecto> findActiveProjects() {
		// TODO Auto-generated method stub
		return null;
	}

}
