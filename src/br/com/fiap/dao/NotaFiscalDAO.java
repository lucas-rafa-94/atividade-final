package br.com.fiap.dao;

import br.com.fiap.entity.NotaFiscal;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by logonrm on 05/12/2017.
 */
public class NotaFiscalDAO extends AbstractDAO<NotaFiscal> {

    public NotaFiscalDAO(EntityManager em) {
        super(em);
    }

    public List<NotaFiscal> listarNotaFiscal(){
        TypedQuery<NotaFiscal> query = em.createQuery("from NotaFiscal f", NotaFiscal.class);
        return query.getResultList();
    }

    public NotaFiscal buscarNotaFiscalPorCliente(String cpf){
        TypedQuery<NotaFiscal> query = em.createQuery("from NotaFiscal f where cliente.cpf = :cpf", NotaFiscal.class);
        query.setParameter("cpf", cpf);
        return query.getSingleResult();
    }

}
