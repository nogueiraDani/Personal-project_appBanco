package main.java.com.dani.model;

import java.math.BigDecimal;
import java.util.List;

import main.java.com.dani.exception.ValorInicialException;
import main.java.com.dani.util.enums.TipoConta;

public class Conta {

    private Long numero;
    private BigDecimal saldo;
    private Cliente cliente;
    private TipoConta tipo;
    private List<Transacao> transacoes; // Histórico de transações

    public Conta(Cliente cliente2, TipoConta tipo2) {
        //TODO Auto-generated constructor stub
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) throws ValorInicialException {
        if (saldo.compareTo(BigDecimal.ZERO) >= 0) {
            this.saldo = saldo;
        } else {
            throw new ValorInicialException("Conta deve ser inicializado com valor maior ou igual a R$ 0,00");
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoConta getTipo() {
        return tipo;
    }

    public void setTipo(TipoConta tipo) {
        this.tipo = tipo;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }

}
