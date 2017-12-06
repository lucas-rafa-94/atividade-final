package br.com.fiap.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by logonrm on 05/12/2017.
 */
@Entity
@Table(name = "NOTA_FISCAL")
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_NF")
    private Integer id;

    @Column(name = "DATA")
    private LocalDateTime data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CPF")
    private Cliente cliente;

    @ManyToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
    @JoinTable(name="PEDIDO",
            joinColumns = {@JoinColumn(name="ID_NF", nullable=false, updatable=false)},
            inverseJoinColumns = {@JoinColumn(name="ID_PRODUTO", nullable=false, updatable=false)})
    private List<Produto> produtos = new ArrayList<>();

    @Column(name = "VALOR_TOTAL")
    private Double total;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString(){
        return "ID - " + this.id + "\n Data - " + this.data + "\n Valor - " + this.total;
     }
}


