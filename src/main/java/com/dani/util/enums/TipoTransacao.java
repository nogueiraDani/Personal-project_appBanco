package main.java.com.dani.util.enums;

/**
 * Enumeração que representa os tipos de transações financeiras realizadas no
 * sistema bancário.
 * Cada constante representa uma operação distinta que pode ser executada em uma
 * conta, sendo utilizada para classificar e identificar a natureza das
 * movimentações
 * financeiras.
 */
public enum TipoTransacao {

    /**
     * Operação de depósito em conta.
     * Representa a adição de fundos à conta, seja em dinheiro, cheque ou
     * transferência.
     */
    DEPOSITO,

    /**
     * Operação de saque em conta.
     * Representa a retirada de fundos da conta, resultando na diminuição do saldo
     * disponível.
     */
    SAQUE,

    /**
     * Operação de transferência enviada para outra conta.
     * Representa o débito em conta decorrente de transferência para outra conta,
     * seja interna ou externa ao banco.
     */
    TRANSFERENCIA_ENVIADA,

    /**
     * Operação de transferência recebida de outra conta.
     * Representa o crédito em conta decorrente de transferência recebida de outra
     * conta, seja interna ou externa ao banco.
     */
    TRANSFERENCIA_RECEBIDA,

    /**
     * Operação de crédito de juros na conta.
     * Representa a aplicação de rendimentos sobre o saldo da conta,
     * comum em contas poupança e investimentos.
     */
    JUROS,

    /**
     * Operação de cobrança de tarifa ou taxa bancária.
     * Representa o débito em conta decorrente de cobranças de serviços bancários,
     * manutenção de conta ou outras taxas aplicáveis.
     */
    TARIFA;

}
