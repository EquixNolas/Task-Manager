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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOne(Long valueId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Proyecto findById(Long valueId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proyecto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
