package br.edu.ifpb.es.daw.dao;

import br.edu.ifpb.es.daw.entities.idclass.NewsIC;
import br.edu.ifpb.es.daw.entities.idclass.NewsIdIC;

import java.util.List;

public interface NewsICDAO {

    void save(NewsIC newsIC) throws PersistenciaDawException;

    NewsIC update(NewsIC newsIC) throws PersistenciaDawException;

    void delete(NewsIC newsIC) throws PersistenciaDawException;

    NewsIC getByID(NewsIdIC id) throws PersistenciaDawException;

    List<NewsIC> getAll() throws PersistenciaDawException;
}
