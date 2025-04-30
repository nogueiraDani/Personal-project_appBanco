package main.java.com.dani.exception;

public class CpfException extends Exception {
    
    public CpfException(String mensagem) {
        super(mensagem);
    }

    public CpfException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

    public CpfException() {
        super();
    }

    public CpfException(Throwable causa) {
        super(causa);
    }

}
