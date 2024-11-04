package br.edu.ifpb.es.daw;

import java.util.List;

import br.edu.ifpb.es.daw.dao.TrackDAO;
import br.edu.ifpb.es.daw.entities.Track;

public class MainTrackDeleteAll {

	public static void main(String[] args) throws DawException {
		TrackDAO dao = new TrackDAO();
		try {
			List<Track> tracks = dao.getAll();
			for (Track track : tracks) {
				dao.delete(track);
			}
		} finally {
			dao.close();
		}
	}

}
