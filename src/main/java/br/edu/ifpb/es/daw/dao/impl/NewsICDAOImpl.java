package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.NewsICDAO;
import br.edu.ifpb.es.daw.entities.idclass.NewsIC;
import br.edu.ifpb.es.daw.entities.idclass.NewsIdIC;
import jakarta.persistence.EntityManagerFactory;

public class NewsICDAOImpl extends AbstractDAOImpl<NewsIC, NewsIdIC> implements NewsICDAO {

	public NewsICDAOImpl(EntityManagerFactory emf) {
		super(NewsIC.class, emf);
	}

}
