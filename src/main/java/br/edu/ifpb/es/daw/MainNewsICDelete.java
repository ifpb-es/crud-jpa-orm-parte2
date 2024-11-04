package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.NewsICDAO;
import br.edu.ifpb.es.daw.entities.idclass.NewsIC;
import br.edu.ifpb.es.daw.entities.idclass.NewsIdIC;

public class MainNewsICDelete {

	public static void main(String[] args) throws DawException {
		NewsICDAO dao = new NewsICDAO();
		try {
			// Primeiro salvar
			NewsIC newsIC = new NewsIC();

			NewsIdIC id = new NewsIdIC();
			id.setLanguage("pt_BR");
			id.setTitle("title " + System.currentTimeMillis());
			newsIC.setLanguage(id.getLanguage());
			newsIC.setTitle(id.getTitle());
			newsIC.setContent("content");

			dao.save(newsIC);

			System.out.println(dao.getAll().size());

			// Depois apagar

			dao.delete(newsIC);

			System.out.println(dao.getAll().size());
		} finally {
			dao.close();
		}
	}

}
