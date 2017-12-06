package br.com.fiap;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.NotaFiscal;
import br.com.fiap.entity.Produto;
import br.com.fiap.facade.Facade;
import org.junit.Assert;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by logonrm on 05/12/2017.
 */
public class MainAplicacao {

    public static String listClientes(List<Cliente> objs){
        StringBuilder sb = new StringBuilder();
            for (int i = 0; i < objs.size(); i++) {
                sb.append("Cpf - " + objs.get(i).getCpf() + " | " + "Nome: " + objs.get(i).getNome() + "\n");
            }

        return sb.toString();
    }


    public static String listProdutos(List<Produto> objs){
        StringBuilder sb = new StringBuilder();
            for (int i = 0; i < objs.size(); i++) {
                sb.append("ID - " + objs.get(i).getId() + " | " + "Nome: " + objs.get(i).getNome() + "\n");
            }

        return sb.toString();
    }

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AtividadeFinal");
        EntityManager em = emf.createEntityManager();

        Facade facade = new Facade(em);

        //Interface Usuario -- Criacao Produto
        Produto produto = new Produto();

        produto.setNome(JOptionPane.showInputDialog("Cadastro Produto - Nome"));
        produto.setDescricao(JOptionPane.showInputDialog("Cadastro Produto - Descricao"));
        produto.setValor(Double.parseDouble(JOptionPane.showInputDialog("Cadastro Produto - Valor")));

        facade.inserirProduto(produto);

        //Interface Usuario -- Criacao Cliente
        Cliente cliente = new Cliente();

        cliente.setNome(JOptionPane.showInputDialog("Cadastro Cliente - Nome"));
        cliente.setEmail(JOptionPane.showInputDialog("Cadastro Cliente - Email"));
        cliente.setCpf(JOptionPane.showInputDialog("Cadastro Cliente - CPF"));
        cliente.setEndereco(JOptionPane.showInputDialog("Cadastro Cliente - Endereço"));
        cliente.setEstadoCivil(JOptionPane.showInputDialog("Cadastro Cliente - Estado Civil"));

        facade.inserirCliente(cliente);

        //Interface Usuario -- Criacao Nota
        NotaFiscal notaFiscal = new NotaFiscal();

        notaFiscal.setCliente(facade.buscarCliente(JOptionPane.showInputDialog(listClientes(facade.listarClientes()) + "\n Insira o CPF correspondente:")));
        String decision = "S";
        List<Produto> produtosEscolhidos = new ArrayList<>();
        while (decision.equals("S")){
            produtosEscolhidos.add(facade.buscarProduto(JOptionPane.showInputDialog(listProdutos(facade.listarProdutos()) + "\n Insira o Nome correspondente:" )));
            decision = JOptionPane.showInputDialog("Deseja inserir outro produto? S|N");
        }
        notaFiscal.setProdutos(produtosEscolhidos);
        notaFiscal.setData(LocalDateTime.now());
        notaFiscal.setTotal(produtosEscolhidos.stream().mapToDouble(o -> o.getValor()).sum());

        facade.inserirNotaFiscal(notaFiscal);

        JFrame frame = new JFrame("JOptionPane Confirmacao nota fiscal");
        JOptionPane.showMessageDialog(frame, "Compra Realizada Com SUCESSO!!!!!");

    }

}
