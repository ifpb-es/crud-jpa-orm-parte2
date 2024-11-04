package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.NewsEIDAO;
import br.edu.ifpb.es.daw.entities.embeddedid.NewsEI;
import br.edu.ifpb.es.daw.entities.embeddedid.NewsIdEI;


public class MainNewsEISave {

	public static void main(String[] args) throws DawException {
		NewsEIDAO dao = new NewsEIDAO();
		try {
			NewsEI newsEI = new NewsEI();
			
			NewsIdEI id = new NewsIdEI();
			id.setLanguage("pt_BR");
			id.setTitle("title " + System.currentTimeMillis());
			newsEI.setId(id);
			newsEI.setContent("content");
			
			System.out.println(newsEI);
			
			dao.save(newsEI);

			System.out.println(newsEI);
		} finally {
			dao.close();
		}
	}

}
