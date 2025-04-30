package main.java.com.dani.exception;

public class ValorDeSaqueException extends Exception{

    public ValorDeSaqueException(String mensagem) {
        super(mensagem);
    }

    public ValorDeSaqueException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

    public ValorDeSaqueException() {
        super();
    }

    public ValorDeSaqueException(Throwable causa) {
        super(causa);
    }

}
