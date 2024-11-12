package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.TrackDAO;
import br.edu.ifpb.es.daw.entities.Track;
import jakarta.persistence.EntityManagerFactory;

public class TrackDAOImpl extends AbstractDAOImpl<Track, Long> implements TrackDAO {

	public TrackDAOImpl(EntityManagerFactory emf) {
		super(Track.class, emf);
	}

}
