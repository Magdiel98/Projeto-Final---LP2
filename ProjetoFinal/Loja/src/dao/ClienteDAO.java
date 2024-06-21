package dao;

import database.Database;
import entity.Cliente;
import exception.DAOException;

import java.util.Collection;

public class ClienteDAO implements DAO<Cliente>{
    private Database database = Database.getInstance();

    @Override
    public void save(Cliente entity) throws DAOException
    {
        try {
            database.save(Cliente.class, entity);
        }
        catch (Exception e)
        {
            throw new DAOException("Erro ao tentar salvar cliente" + e.getMessage());
        }
    }

    @Override
    public Collection<Cliente> findAll() throws DAOException{
        try {
            return database.findAll(Cliente.class);
        }
        catch(Exception e)
        {
            throw new DAOException("Erro ao tentar encontrar clientes" + e.getMessage());
        }
    }

    @Override
    public void update(int id, Cliente entity) throws DAOException
    {
        try{
            database.update(Cliente.class, id, entity);
        }
        catch (Exception e)
        {
            throw new DAOException("Erro ao tentar atualizar cliente " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) throws DAOException
    {
        try{
            database.delete(Cliente.class, id);
        }
        catch (Exception e)
        {
            throw new DAOException("Erro ao tentar deletar cliente" + e.getMessage());
        }
    }
}
