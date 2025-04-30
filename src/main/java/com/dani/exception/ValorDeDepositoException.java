package main.java.com.dani.exception;

public class ValorDeDepositoException extends Exception {

    public ValorDeDepositoException(String mensagem) {
        super(mensagem);
    }

    public ValorDeDepositoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

    public ValorDeDepositoException() {
        super();
    }

    public ValorDeDepositoException(Throwable causa) {
        super(causa);
    }

}
