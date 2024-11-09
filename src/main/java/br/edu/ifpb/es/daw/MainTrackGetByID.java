package br.edu.ifpb.es.daw;

import java.math.BigDecimal;

import br.edu.ifpb.es.daw.dao.TrackDAO;
import br.edu.ifpb.es.daw.dao.impl.TrackDAOImpl;
import br.edu.ifpb.es.daw.entities.Track;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainTrackGetByID {

	public static void main(String[] args) throws DawException {
		try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
			TrackDAO dao = new TrackDAOImpl(emf);
			// Primeiro salvar
			Track track = new Track();

			track.setTitle("title");
			track.setDescription("description");
			track.setDuration(new BigDecimal("123.45"));
			track.setWav("<bytes da música seriam colocados aqui>".getBytes());

			dao.save(track);

			// Depois recuperar pelo identificador
			Track resultado = dao.getByID(track.getId());

			System.out.println(track.equals(resultado));
		}
	}

}
