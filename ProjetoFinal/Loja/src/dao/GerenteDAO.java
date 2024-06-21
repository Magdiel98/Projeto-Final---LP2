package dao;

import database.Database;
import entity.Gerente;
import exception.DAOException;

import java.util.Collection;
import java.util.GregorianCalendar;

public class GerenteDAO implements DAO<Gerente>{
    private Database database = Database.getInstance();

    @Override
    public void save(Gerente entity) throws DAOException
    {
        try {
            database.save(Gerente.class, entity);
        }
        catch (Exception e)
        {
            throw new DAOException("Erro ao tentar salvar gerente " + e.getMessage());
        }
    }

    @Override
    public Collection<Gerente> findAll() throws DAOException{
        try {
            return database.findAll(Gerente.class);
        }
        catch(Exception e)
        {
            throw new DAOException("Erro ao tentar encontrar gerente" + e.getMessage());
        }

    }

    @Override
    public void update(int id, Gerente entity) throws DAOException
    {
        try{
            database.update(Gerente.class, id, entity);
        }
        catch (Exception e)
        {
            throw new DAOException("Erro ao tentar atualizar gerente" + e.getMessage());
        }
    }

    @Override
    public void delete(int id) throws DAOException
    {
        try{
            database.delete(Gerente.class, id);
        }
        catch (Exception e)
        {
            throw new DAOException("Erro ao tentar deletar gerente" + e.getMessage());
        }
    }
}