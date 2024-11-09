package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.NewsICDAO;
import br.edu.ifpb.es.daw.dao.impl.NewsICDAOImpl;
import br.edu.ifpb.es.daw.entities.idclass.NewsIC;
import br.edu.ifpb.es.daw.entities.idclass.NewsIdIC;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class MainNewsICUpdate {
	
	public static void main(String[] args) throws DawException {
		try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
			NewsICDAO dao = new NewsICDAOImpl(emf);
			// Primeiro salvar
			NewsIC newsIC = new NewsIC();
			
			NewsIdIC id = new NewsIdIC();
			id.setLanguage("pt_BR");
			id.setTitle("title " + System.currentTimeMillis());
			newsIC.setLanguage(id.getLanguage());
			newsIC.setTitle(id.getTitle());
			newsIC.setContent("content");

			dao.save(newsIC);

			System.out.println(newsIC);
			
			// Depois atualizar
			newsIC.setContent("outro conteúdo");
			
			dao.update(newsIC);
			
			System.out.println(newsIC);
		}
	}

}
