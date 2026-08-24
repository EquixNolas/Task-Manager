package dao;


import entities.Usuario;

public interface IUsuarioDao extends IGenericDao<Usuario, Long> {
	Usuario findByEmail(String email);
}
