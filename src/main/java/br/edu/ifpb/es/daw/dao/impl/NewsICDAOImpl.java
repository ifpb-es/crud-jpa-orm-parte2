package br.edu.ifpb.es.daw.dao.impl;

import java.util.List;

import br.edu.ifpb.es.daw.dao.DAO;
import br.edu.ifpb.es.daw.dao.NewsICDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.entities.idclass.NewsIC;
import br.edu.ifpb.es.daw.entities.idclass.NewsIdIC;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;

public class NewsICDAOImpl extends DAO implements NewsICDAO {

	public NewsICDAOImpl(EntityManagerFactory emf) {
		super(emf);
	}

	@Override
	public void save(NewsIC newsIC) throws PersistenciaDawException {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(newsIC);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new PersistenciaDawException("Ocorreu algum erro ao tentar salvar a notícia.", pe);
		} finally {
			em.close();
		}
	}

	@Override
	public NewsIC update(NewsIC newsIC) throws PersistenciaDawException {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		NewsIC resultado = newsIC;
		try {
			resultado = em.merge(newsIC);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new PersistenciaDawException("Ocorreu algum erro ao tentar atualizar a notícia.", pe);
		} finally {
			em.close();
		}
		return resultado;
	}

	@Override
	public void delete(NewsIC newsIC) throws PersistenciaDawException {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			NewsIdIC primaryKey = new NewsIdIC();
			primaryKey.setTitle(newsIC.getTitle());
			primaryKey.setLanguage(newsIC.getLanguage());
			newsIC = em.find(NewsIC.class, primaryKey);
			em.remove(newsIC);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new PersistenciaDawException("Ocorreu algum erro ao tentar remover a notícia.", pe);
		} finally {
			em.close();
		}
	}

	@Override
	public NewsIC getByID(NewsIdIC id) throws PersistenciaDawException {
		EntityManager em = getEntityManager();
		NewsIC resultado = null;
		try {
			resultado = em.find(NewsIC.class, id);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new PersistenciaDawException("Ocorreu algum erro ao tentar recuperar a notícia com base no ID.", pe);
		} finally {
			em.close();
		}

		return resultado;
	}

	@Override
	public List<NewsIC> getAll() throws PersistenciaDawException {
		EntityManager em = getEntityManager();
		List<NewsIC> resultado = null;
		try {
			TypedQuery<NewsIC> query = em.createQuery("SELECT u FROM NewsIC u", NewsIC.class);
			resultado = query.getResultList();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new PersistenciaDawException("Ocorreu algum erro ao tentar recuperar todas as notícias.", pe);
		} finally {
			em.close();
		}
		return resultado;
	}

}
