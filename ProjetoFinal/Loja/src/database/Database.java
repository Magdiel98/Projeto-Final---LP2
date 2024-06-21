package database;

import entity.Entity;
import exception.DatabaseException;

import javax.xml.crypto.Data;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Database{

    //Projeto Singleton:
    private static Database instance;

    private Database()
    {

    }

    public static Database getInstance()
    {
        if(instance == null)
        {
            instance = new Database();
        }
        return instance;
    }

    //Mapa:
    private Map<Class<? extends Entity>, DatabaseTable<? extends Entity>> tabelas = new HashMap<>();

    public <T extends Entity> void save(Class<T> classe, T entity) throws DatabaseException
    {
        try {
            if (!tabelas.containsKey(classe)) {
                tabelas.put(classe, new DatabaseTable<T>());
            }

            ((DatabaseTable<T>) tabelas.get(classe)).save(entity);
        }
        catch(Exception e)
        {
            throw new DatabaseException("Erro ao tentar salvar no Database" + e.getMessage());
        }
    }

    public <T extends Entity> Collection<T> findAll(Class<T> classe) throws DatabaseException
    {
        try {
            if (!tabelas.containsKey(classe)) {
                tabelas.put(classe, new DatabaseTable<T>());
            }

            return ((DatabaseTable<T>) tabelas.get(classe)).findAll();
        }
        catch (Exception e)
        {
            throw new DatabaseException("Erro ao tentar encontrar elementos no Database" + e.getMessage());
        }

    }

    public <T extends Entity> void update(Class<T> classe, int id, T entity) throws DatabaseException
    {
        try {
            if (!tabelas.containsKey(classe)) {
                tabelas.put(classe, new DatabaseTable<T>());
            }

            ((DatabaseTable<T>) tabelas.get(classe)).update(id, entity);
        }
        catch(Exception e)
        {
            throw new DatabaseException("Erro ao tentar atualizar no Database" + e.getMessage());
        }
    }

    public <T extends Entity> void delete(Class<T> classe, int id) throws DatabaseException
    {
        try {
            if (!tabelas.containsKey(classe)) {
                tabelas.put(classe, new DatabaseTable<T>());
            }

            ((DatabaseTable<T>) tabelas.get(classe)).delete(id);
        }
        catch (Exception e)
        {
            throw new DatabaseException("Erro ao tentar deletar elemento do Database" + e.getMessage());
        }

    }



}


