package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.model.Usuario;
import br.com.fiap.utils.JPAUtil;

public class UsuarioDAO {
	public void save(Usuario usuario) {
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
		manager.close();

	}

	public List<Usuario> getAll() {
		EntityManager manager = JPAUtil.getEntityManager();
        String jpsql = "SELECT u FROM Usuario u";
        List<Usuario> lista = manager.createQuery(jpsql, Usuario.class).getResultList();
        return lista;
	}

}
