package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.NewsEIDAO;
import br.edu.ifpb.es.daw.dao.impl.NewsEIDAOImpl;
import br.edu.ifpb.es.daw.entities.embeddedid.NewsEI;
import br.edu.ifpb.es.daw.entities.embeddedid.NewsIdEI;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class MainNewsEISave {

	public static void main(String[] args) throws DawException {
		try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
			NewsEIDAO dao = new NewsEIDAOImpl(emf);
			NewsEI newsEI = new NewsEI();
			
			NewsIdEI id = new NewsIdEI();
			id.setLanguage("pt_BR");
			id.setTitle("title " + System.currentTimeMillis());
			newsEI.setId(id);
			newsEI.setContent("content");
			
			System.out.println(newsEI);
			
			dao.save(newsEI);

			System.out.println(newsEI);
		}
	}

}
