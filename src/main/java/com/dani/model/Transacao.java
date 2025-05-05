package main.java.com.dani.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Objects;

import main.java.com.dani.util.enums.TipoTransacao;

public class Transacao {
    private Long id;
    private LocalDateTime dataHora;
    private TipoTransacao tipoTransacao; // DEPÓSITO, SAQUE, TRANSFERÊNCIA, etc.
    private BigDecimal valor;
    private BigDecimal saldoAtual;
    private String descricao;
    private Conta conta; // Conta associada à transação

    // Construtor
    public Transacao(LocalDateTime dataHora, TipoTransacao tipo, BigDecimal valor,
            BigDecimal saldoAtual, String descricao, Conta conta) {

        this.dataHora = Objects.requireNonNull(
                dataHora,
                "Data/hora não pode ser nula");
        this.tipoTransacao = Objects.requireNonNull(
                tipo,
                "Tipo não pode ser nulo");
        this.valor = Objects.requireNonNull(
                valor,
                "Valor não pode ser nulo")
                .setScale(2, RoundingMode.HALF_EVEN);
        this.saldoAtual = Objects.requireNonNull(
                saldoAtual,
                "Saldo atual não pode ser nulo")
                .setScale(2, RoundingMode.HALF_EVEN);

        this.descricao = descricao; // Pode ser nulo
        this.conta = Objects.requireNonNull(
                conta,
                "Conta não pode ser nula");
    }

    // Getters
    public Long getId() {
        return id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public BigDecimal getSaldoAtual() {
        return saldoAtual;
    }

    public String getDescricao() {
        return descricao;
    }

    public Conta getConta() {
        return conta;
    }

    // Setters (apenas para campos que podem ser alterados)
    public void setId(Long id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Métodos auxiliares
    public boolean isCredito() {
        return valor.compareTo(BigDecimal.ZERO) > 0;
    }

    public boolean isDebito() {
        return valor.compareTo(BigDecimal.ZERO) < 0;
    }

    @Override
    public String toString() {
        return String.format(
                "Transacao[id=%d, dataHora=%s, tipo=%s, valor=%s, saldoAtual=%s, descricao=%s]",
                id, dataHora, tipoTransacao, valor, saldoAtual, descricao);
    }

}
