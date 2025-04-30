package main.java.com.dani.exception;

public class SenhaInvalidaException extends Exception {
    
    public SenhaInvalidaException(String mensagem) {
        super(mensagem);
    }

    public SenhaInvalidaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

    public SenhaInvalidaException() {
        super();
    }

    public SenhaInvalidaException(Throwable causa) {
        super(causa);
    }

}
