package br.edu.ifpb.es.daw.dao;

import br.edu.ifpb.es.daw.entities.Track;

import java.util.List;

public interface TrackDAO {

    void save(Track track) throws PersistenciaDawException;

    Track update(Track track) throws PersistenciaDawException;

    void delete(Track track) throws PersistenciaDawException;

    Track getByID(long id) throws PersistenciaDawException;

    List<Track> getAll() throws PersistenciaDawException;
}
