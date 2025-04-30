package main.java.com.dani.model;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.java.com.dani.exception.CpfException;
import main.java.com.dani.exception.SenhaInvalidaException;

public class Cliente {

    private String nome;
    private String sobrenome;
    private String senha;
    private String cpf;

    private Scanner scanner = new Scanner(System.in);

    public Cliente(String nome, String sobrenome, String cpf, String senha) throws SenhaInvalidaException, CpfException {
        setNome(sobrenome);
        setSobrenome(sobrenome);
        setCpf(cpf);
        setSenha(senha);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws CpfException {
        if (validarCpf(cpf)) {
            this.cpf = cpf;
        } else {
            throw new CpfException("Número de CPF inválido.");
        }
    }

    private boolean validarCpf(String cpf2) {
        // TODO parei aqui, estava validando o cpf
        throw new UnsupportedOperationException("Unimplemented method 'validarCpf'");
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) throws SenhaInvalidaException {
        if (isStrongSenha(senha)) {
            this.senha = senha;
        } else {
            throw new SenhaInvalidaException("Senha inválida, não contém todos os requisitos.");
        }
    }

    public boolean isStrongSenha(String senha) {

        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]\\{\\}\\\\|;:'\"<>,.?\\/])[A-Za-z\\d!@#$%^&*()_+\\-=\\[\\]\\{\\}\\\\|;:'\"<>,.?\\/]{8}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(senha);

        return matcher.matches();

    }

    public boolean validarSenha() {
        String senha = pedirSenha();
        return senha.equals(getSenha());
    }

    private String pedirSenha() {
        System.out.println("Por favor, digite a sua senha:");
        String senha = scanner.next();
        return senha;
    }

    private String pedirNovaSenha() {
        System.out.println("Por favor, digite a nova senha:");
        String senha = scanner.next();
        scanner.close();
        return senha;
    }

    public void alterarSenha() throws SenhaInvalidaException {
        if (validarSenha()) {
            String novaSenha = pedirNovaSenha();
            if (isStrongSenha(novaSenha)) {
                setSenha(novaSenha);
            } else {
                throw new SenhaInvalidaException("A nova senha não é forte.");
            }
        }

    }

    @Override
    public String toString() {
        return "Cliente:" + nome + " " + sobrenome;
    }

}
