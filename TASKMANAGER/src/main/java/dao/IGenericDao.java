package dao;

import java.util.List;

public interface IGenericDao<E,ID> {

	int insertOne(E entity);
	int updateOne(E entity);
	int deleteOne(ID valueId);
	E findById(ID valueId);
	List<E> findAll();
	
}
