package database;

import entity.Entity;
import exception.DatabaseException;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface DatabaseTableI<T extends Entity>{
    void save(T entity) throws DatabaseException; //Criar DatabaseException depois
    Optional<T> findById(int id) throws DatabaseException;
    Collection<T> findAll() throws DatabaseException;
    void update(int id, T entity) throws DatabaseException;
    void delete(int id) throws DatabaseException;
}
