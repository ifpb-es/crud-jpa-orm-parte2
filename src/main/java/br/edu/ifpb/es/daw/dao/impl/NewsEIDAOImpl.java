package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.NewsEIDAO;
import br.edu.ifpb.es.daw.entities.embeddedid.NewsEI;
import br.edu.ifpb.es.daw.entities.embeddedid.NewsIdEI;
import jakarta.persistence.EntityManagerFactory;

public class NewsEIDAOImpl extends AbstractDAOImpl<NewsEI, NewsIdEI> implements NewsEIDAO {

	public NewsEIDAOImpl(EntityManagerFactory emf) {
		super(NewsEI.class, emf);
	}

}
