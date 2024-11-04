package br.edu.ifpb.es.daw;

import java.math.BigDecimal;

import br.edu.ifpb.es.daw.dao.TrackDAO;
import br.edu.ifpb.es.daw.entities.Track;

public class MainTrackSave {

	public static void main(String[] args) throws DawException {
		TrackDAO dao = new TrackDAO();
		try {
			Track track = new Track();

			track.setTitle("title");
			track.setDescription("description");
			track.setDuration(new BigDecimal("100.5"));
			track.setWav("<bytes da música seriam colocados aqui>".getBytes());

			System.out.println(track);

			dao.save(track);

			System.out.println(track);
		} finally {
			dao.close();
		}
	}

}
