package main.java.com.dani.model;

import main.java.com.dani.exception.SenhaInvalidaException;

public class Conta {

    private Cliente cliente;
    private Double saldo;

    public Conta(Cliente cliente, Double saldo) throws SenhaInvalidaException {
        setCliente(cliente);
        setSaldo(saldo);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    

}
