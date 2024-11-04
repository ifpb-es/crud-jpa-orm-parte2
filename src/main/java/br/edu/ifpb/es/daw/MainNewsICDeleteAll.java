package br.edu.ifpb.es.daw;

import java.util.List;

import br.edu.ifpb.es.daw.dao.NewsICDAO;
import br.edu.ifpb.es.daw.entities.idclass.NewsIC;



public class MainNewsICDeleteAll {

	public static void main(String[] args) throws DawException {
		NewsICDAO dao = new NewsICDAO();
		try {
			List<NewsIC> newsICs = dao.getAll();
			for (NewsIC newsIC : newsICs) {
				dao.delete(newsIC);
			}
		} finally {
			dao.close();
		}
	}
	
	
}
