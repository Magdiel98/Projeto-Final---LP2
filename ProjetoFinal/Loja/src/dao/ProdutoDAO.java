
package dao;

import database.Database;
import entity.Gerente;
import entity.Produto;
import exception.DAOException;

import java.util.Collection;

public class ProdutoDAO implements DAO<Produto>{

    private Database database = Database.getInstance();

    @Override
    public void save(Produto entity) throws DAOException
    {
        try {
            database.save(Produto.class, entity);
        }
        catch (Exception e)
        {
            throw new DAOException("Erro ao tentar salvar produto" + e.getMessage());
        }
    }

    @Override
    public Collection<Produto> findAll() throws DAOException{
        try {
            return database.findAll(Produto.class);
        }
        catch(Exception e)
        {
            throw new DAOException("Erro ao tentar encontrar produtos" + e.getMessage());
        }

    }

    @Override
    public void update(int id, Produto entity) throws DAOException
    {
        try{
            database.update(Produto.class, id, entity);
        }
        catch (Exception e)
        {
            throw new DAOException("Erro ao tentar atualizar produto" + e.getMessage());
        }
    }

    @Override
    public void delete(int id) throws DAOException
    {
        try{
            database.delete(Produto.class, id);
        }
        catch (Exception e)
        {
            throw new DAOException("Erro ao tentar deletar produto" + e.getMessage());
        }
    }
}

