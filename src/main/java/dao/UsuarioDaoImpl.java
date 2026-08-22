package dao;

import java.util.List;

import entities.Usuario;

public class UsuarioDaoImpl extends AbstractDaoImpl implements IUsuarioDao {

	
	public UsuarioDaoImpl() {
		super();
	}

	@Override
	public int insertOne(Usuario entity) {
		try {
			tx.begin();
				em.persist(entity);
			tx.commit();
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	@Override
	public int updateOne(Usuario entity) {
		try {
			if (findById(entity.getUserId()) != null) 
			{
				tx.begin();
					em.merge(entity);
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
		Usuario usuario = findById(valueId);
		try {
			if (usuario != null)
			{
				tx.begin();
					em.remove(usuario);
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
	public Usuario findById(Long valueId) {
		return em.find(Usuario.class, valueId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findAll() {
		jpql = "from Usuario u";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

}
