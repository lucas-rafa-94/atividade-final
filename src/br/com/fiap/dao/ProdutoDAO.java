package br.com.fiap.dao;

import br.com.fiap.entity.Produto;
import br.com.fiap.entity.Produto;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by logonrm on 05/12/2017.
 */
public class ProdutoDAO extends AbstractDAO<Produto> {

    public ProdutoDAO(EntityManager em) {
        super(em);
    }

    public List<Produto> listarProdutos(){
        TypedQuery<Produto> query = em.createQuery("from Produto f", Produto.class);
        return query.getResultList();
    }

    public Produto buscarProdutoPorNome(String nome){
        TypedQuery<Produto> query = em.createQuery("from Produto f where nome = :nome", Produto.class);
        query.setParameter("nome", nome);
        return query.getSingleResult();
    }

}
