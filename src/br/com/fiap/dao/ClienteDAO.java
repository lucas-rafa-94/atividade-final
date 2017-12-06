package br.com.fiap.dao;

import br.com.fiap.entity.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by logonrm on 05/12/2017.
 */
public class ClienteDAO extends AbstractDAO<Cliente> {

    public ClienteDAO(EntityManager em) {
        super(em);
    }

    public List<Cliente> listarClientes(){
        TypedQuery<Cliente> query = em.createQuery("from Cliente f", Cliente.class);
        return query.getResultList();
    }

    public Cliente buscarCliente(String cpf){
        TypedQuery<Cliente> query = em.createQuery("from Cliente f where cpf = :cpf", Cliente.class);
        query.setParameter("cpf", cpf);
        return query.getSingleResult();
    }

}
