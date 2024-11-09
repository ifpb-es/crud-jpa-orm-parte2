package br.edu.ifpb.es.daw.dao;

import br.edu.ifpb.es.daw.entities.embeddedid.NewsEI;
import br.edu.ifpb.es.daw.entities.embeddedid.NewsIdEI;

import java.util.List;

public interface NewsEIDAO {

    void save(NewsEI newsEI) throws PersistenciaDawException;

    NewsEI update(NewsEI newsEI) throws PersistenciaDawException;

    void delete(NewsEI newsEI) throws PersistenciaDawException;

    NewsEI getByID(NewsIdEI newsIdEI) throws PersistenciaDawException;

    List<NewsEI> getAll() throws PersistenciaDawException;
}
