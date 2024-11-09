package br.edu.ifpb.es.daw.dao.impl;

import java.util.List;

import br.edu.ifpb.es.daw.dao.DAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.TrackDAO;
import br.edu.ifpb.es.daw.entities.Track;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;


public class TrackDAOImpl extends DAO implements TrackDAO {

	public TrackDAOImpl(EntityManagerFactory emf) {
		super(emf);
	}

	@Override
	public void save(Track track) throws PersistenciaDawException {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(track);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new PersistenciaDawException("Ocorreu algum erro ao tentar salvar a faixa.", pe);
		} finally {
			em.close();
		}
	}

	@Override
	public Track update(Track track) throws PersistenciaDawException {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Track resultado = track;
		try {
			resultado = em.merge(track);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new PersistenciaDawException("Ocorreu algum erro ao tentar atualizar a faixa.", pe);
		} finally {
			em.close();
		}
		return resultado;
	}

	@Override
	public void delete(Track track) throws PersistenciaDawException {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			track = em.find(Track.class, track.getId());
			em.remove(track);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new PersistenciaDawException("Ocorreu algum erro ao tentar remover a faixa.", pe);
		} finally {
			em.close();
		}
	}

	@Override
	public Track getByID(long id) throws PersistenciaDawException {
		EntityManager em = getEntityManager();
		Track resultado = null;
		try {
			resultado = em.find(Track.class, id);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new PersistenciaDawException("Ocorreu algum erro ao tentar recuperar a faixa com base no ID.", pe);
		} finally {
			em.close();
		}

		return resultado;
	}

	@Override
	public List<Track> getAll() throws PersistenciaDawException {
		EntityManager em = getEntityManager();
		List<Track> resultado = null;
		try {
			TypedQuery<Track> query = em.createQuery("SELECT t FROM Track t", Track.class);
			resultado = query.getResultList();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new PersistenciaDawException("Ocorreu algum erro ao tentar recuperar todas as faixas.", pe);
		} finally {
			em.close();
		}
		return resultado;
	}

}
