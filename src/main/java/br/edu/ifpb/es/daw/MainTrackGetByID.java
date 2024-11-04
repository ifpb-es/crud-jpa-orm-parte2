package br.edu.ifpb.es.daw;

import java.math.BigDecimal;

import br.edu.ifpb.es.daw.dao.TrackDAO;
import br.edu.ifpb.es.daw.entities.Track;

public class MainTrackGetByID {

	public static void main(String[] args) throws DawException {
		TrackDAO dao = new TrackDAO();
		try {
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
		} finally {
			dao.close();
		}
	}

}
