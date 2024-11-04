package br.edu.ifpb.es.daw;

import java.util.List;

import br.edu.ifpb.es.daw.dao.NewsEIDAO;
import br.edu.ifpb.es.daw.entities.embeddedid.NewsEI;

public class MainNewsEIDeleteAll {

	public static void main(String[] args) throws DawException {
		NewsEIDAO dao = new NewsEIDAO();
		try {
			List<NewsEI> newsEIs = dao.getAll();
			for (NewsEI newsEI : newsEIs) {
				dao.delete(newsEI);
			}
		} finally {
			dao.close();
		}
	}
	
}
