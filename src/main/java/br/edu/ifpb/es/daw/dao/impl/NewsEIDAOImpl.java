package br.edu.ifpb.es.daw.dao.impl;

import java.util.List;

import br.edu.ifpb.es.daw.dao.DAO;
import br.edu.ifpb.es.daw.dao.NewsEIDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.entities.embeddedid.NewsEI;
import br.edu.ifpb.es.daw.entities.embeddedid.NewsIdEI;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;

public class NewsEIDAOImpl extends DAO implements NewsEIDAO {

	public NewsEIDAOImpl(EntityManagerFactory emf) {
		super(emf);
	}

	@Override
	public void save(NewsEI newsEI) throws PersistenciaDawException {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(newsEI);
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
	public NewsEI update(NewsEI newsEI) throws PersistenciaDawException {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		NewsEI resultado = newsEI;
		try {
			resultado = em.merge(newsEI);
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
	public void delete(NewsEI newsEI) throws PersistenciaDawException {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			newsEI = em.find(NewsEI.class, newsEI.getId());
			em.remove(newsEI);
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
	public NewsEI getByID(NewsIdEI newsIdEI) throws PersistenciaDawException {
		EntityManager em = getEntityManager();
		NewsEI resultado = null;
		try {
			resultado = em.find(NewsEI.class, newsIdEI);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new PersistenciaDawException("Ocorreu algum erro ao tentar recuperar a notícia com base no ID.", pe);
		} finally {
			em.close();
		}

		return resultado;
	}

	@Override
	public List<NewsEI> getAll() throws PersistenciaDawException {
		EntityManager em = getEntityManager();
		List<NewsEI> resultado = null;
		try {
			TypedQuery<NewsEI> query = em.createQuery("SELECT u FROM NewsEI u", NewsEI.class);
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
