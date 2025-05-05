package main.java.com.dani.exception;

public class ValorInicialException extends Exception{

    public ValorInicialException(String mensagem) {
        super(mensagem);
    }

    public ValorInicialException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

    public ValorInicialException() {
        super();
    }

    public ValorInicialException(Throwable causa) {
        super(causa);
    }

}
