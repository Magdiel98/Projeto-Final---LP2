package database;

import entity.Entity;
import exception.DatabaseException;
import exception.EntityNotFoundException;
import javafx.print.Collation;

import java.util.*;


public class DatabaseTable <T extends Entity> implements DatabaseTableI<T>{

    private Map<Integer, T> elementos = new HashMap<>();

    private int identidade = 0; //Atributo do tipo inteiro que deve ser incrementado e usado como id de novas entidades durante
    //uma inserção

    @Override
    public void save(T entity) throws DatabaseException{
        try {
            entity.setId(++identidade);
            elementos.put(entity.getId(), entity); //Salva um objeto do tipo T (Produto, Funcionario etc) com um id
        }
        catch (Exception e)
        {
            throw new DatabaseException("Erro ao tentar salvar elementos" + e.getMessage());
        }
    }


    @Override
    public Optional<T> findById(int id) throws EntityNotFoundException{
        return null;
    }


    @Override
    public Collection<T> findAll() throws DatabaseException{
        try {
            return elementos.values();
        }
        catch(Exception e)
        {
            throw new DatabaseException("Erro ao tentar encontrar elementos" + e.getMessage());
        }
    }



    @Override
    public void update(int id, T entity) throws EntityNotFoundException
    {
        try {
            elementos.replace(id, entity);
        }
        catch (Exception e)
        {
            throw new EntityNotFoundException("Erro ao tentar atualizar elemento" + e.getMessage());
        }
    }

    @Override
    public void delete(int id) throws EntityNotFoundException
    {
        try {
            elementos.remove(id);
        }
        catch (Exception e)
        {
            throw new EntityNotFoundException("Erro ao tentar deletar elemento"+ e.getMessage());
        }
    }



}
