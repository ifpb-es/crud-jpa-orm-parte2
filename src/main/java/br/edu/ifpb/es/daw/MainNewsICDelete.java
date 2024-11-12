package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.NewsICDAO;
import br.edu.ifpb.es.daw.dao.impl.NewsICDAOImpl;
import br.edu.ifpb.es.daw.entities.idclass.NewsIC;
import br.edu.ifpb.es.daw.entities.idclass.NewsIdIC;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainNewsICDelete {

	public static void main(String[] args) throws DawException {
		try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
			NewsICDAO dao = new NewsICDAOImpl(emf);
			// Primeiro salvar
			NewsIC newsIC = new NewsIC();

			NewsIdIC primaryKey = new NewsIdIC();
			primaryKey.setLanguage("pt_BR");
			primaryKey.setTitle("title " + System.currentTimeMillis());
			newsIC.setLanguage(primaryKey.getLanguage());
			newsIC.setTitle(primaryKey.getTitle());
			newsIC.setContent("content");

			dao.save(newsIC);

			System.out.println(dao.getAll().size());

			// Depois apagar

			dao.delete(primaryKey);

			System.out.println(dao.getAll().size());
		}
	}

}
