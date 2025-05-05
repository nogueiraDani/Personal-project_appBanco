package main.java.com.dani.exception;

public class ValorInvalidoException extends Exception {

    public ValorInvalidoException(String mensagem) {
        super(mensagem);
    }

    public ValorInvalidoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

    public ValorInvalidoException() {
        super();
    }

    public ValorInvalidoException(Throwable causa) {
        super(causa);
    }
}
