package main.java.com.dani.model;

import main.java.com.dani.exception.SenhaInvalidaException;
import main.java.com.dani.exception.ValorDeDepositoException;
import main.java.com.dani.exception.ValorDeSaqueException;

public class Banco {

    // private List<Conta> contas = new ArrayList<>();
    // private List<Cliente> clientes = new ArrayList<>();
    private final Double TAXA_SAQUE = 0.01;

    public Double getTAXA_SAQUE() {
        return TAXA_SAQUE;
    }

    public void sacar(Conta conta, Double valorSaque) throws ValorDeSaqueException, SenhaInvalidaException {
        Double valorSaqueComTaxa = valorSaque + (valorSaque * TAXA_SAQUE);

        if (valorDeSaqueEhValido(valorSaque, conta, valorSaqueComTaxa)) {
            if (conta.getCliente().validarSenha()) {
                conta.setSaldo(conta.getSaldo() - valorSaqueComTaxa);
            } else {
                throw new SenhaInvalidaException("A senha não está correta.");
            }
        } else {
            throw new ValorDeSaqueException("O valor para o saque é invalido.");
        }

        imprimirValorSacado(valorSaqueComTaxa);
        imprimirSaldoAtual(conta);

    }

    private boolean valorDeSaqueEhValido(Double valorSaque, Conta conta, Double valorSaqueComTaxa) {
        return valorSaque > 0 && valorSaqueComTaxa <= conta.getSaldo();
    }

    private void imprimirSaldoAtual(Conta conta) {
        System.out.printf("O saldo atual é R$%.2f.\n", conta.getSaldo());
    }

    private void imprimirValorSacado(Double valorDoSaqueComTaxa) {
        System.out.printf("Valor sacado R$%.2f.\n", valorDoSaqueComTaxa);
    }

    public void depositar(Conta conta, Double valorDeposito) throws ValorDeDepositoException {
        if (valorDeposito > 0) {
            conta.setSaldo(conta.getSaldo() + valorDeposito);
        } else {
            throw new ValorDeDepositoException("o valor para depósito é inválido.");
        }
    }

    public void transferir() {
        // - Adicione o método de transferência bancária.
        // - O valor de uma conta deverá ir para a outra.
    }

}
