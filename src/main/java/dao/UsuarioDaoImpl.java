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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOne(Long valueId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Usuario findById(Long valueId) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findAll() {
		jpql = "from Usuario u";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

}
