package br.edu.ifpb.es.daw;

import java.util.List;

import br.edu.ifpb.es.daw.dao.NewsICDAO;
import br.edu.ifpb.es.daw.dao.impl.NewsICDAOImpl;
import br.edu.ifpb.es.daw.entities.idclass.NewsIC;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class MainNewsICGetAll {

	public static void main(String[] args) throws DawException {
		try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
			NewsICDAO dao = new NewsICDAOImpl(emf);
			List<NewsIC> newsICs = dao.getAll();

			for (NewsIC newsIC : newsICs) {
				System.out.println(newsIC);
			}

		}
	}

}
