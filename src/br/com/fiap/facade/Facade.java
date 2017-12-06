package br.com.fiap.facade;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.NotaFiscalDAO;
import br.com.fiap.dao.ProdutoDAO;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.NotaFiscal;
import br.com.fiap.entity.Produto;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by logonrm on 05/12/2017.
 */
public class Facade {

    private EntityManager entityManager;
    private ProdutoDAO produtoDAO;
    private ClienteDAO clienteDAO;
    private NotaFiscalDAO notaFiscalDAO;

    public Facade(EntityManager entityManager) {
        this.entityManager = entityManager;
        produtoDAO = new ProdutoDAO(entityManager);
        clienteDAO = new ClienteDAO(entityManager);
        notaFiscalDAO = new NotaFiscalDAO(entityManager);
    }

    public Produto inserirProduto(Produto produto) {
        return produtoDAO.salvar(produto);
    }

    public Cliente inserirCliente(Cliente cliente) {
        return clienteDAO.salvar(cliente);
    }

    public NotaFiscal inserirNotaFiscal(NotaFiscal nf) {
        return notaFiscalDAO.salvar(nf);
    }

    public List<Cliente> listarClientes() {
        return clienteDAO.listarClientes();
    }

    public Cliente buscarCliente(String cpf) {
        return clienteDAO.buscarCliente(cpf);
    }


    public List<Produto> listarProdutos() {
        return produtoDAO.listarProdutos();
    }

    public Produto buscarProduto(String nome) {
        return produtoDAO.buscarProdutoPorNome(nome);
    }

}
