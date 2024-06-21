package service;

import dao.GerenteDAO;
import entity.Gerente;

import java.util.Collection;

public class GerenteService {
    private GerenteDAO gerenteDAO = new GerenteDAO();
    private Gerente gerente = new Gerente();


    public boolean login(String email, String senha)
    {
        try{
            gerenteDAO.save(gerente);
            Collection<Gerente> gerentes = gerenteDAO.findAll();
            for(Gerente gerente : gerentes)
            {
                if(gerente.getEmail().equals(email) && gerente.getSenha().equals(senha))
                {
                    return true;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return false;
    }
}
