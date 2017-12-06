package br.com.fiap.dao;

import br.com.fiap.entity.NotaFiscal;

import javax.persistence.EntityManager;

/**
 * Created by logonrm on 05/12/2017.
 */
public class AbstractDAO<T> {

    final EntityManager em;

    public AbstractDAO(EntityManager em) {
        this.em = em;
    }

    public T salvar(T object){
        try {
            em.getTransaction().begin();
            object = em.merge(object);
            em.getTransaction().commit();

            return object;

        } catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

}
