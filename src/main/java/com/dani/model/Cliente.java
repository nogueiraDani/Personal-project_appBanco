package main.java.com.dani.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.java.com.dani.exception.CpfException;
import main.java.com.dani.exception.SenhaInvalidaException;

public class Cliente {

    private Long id;
    private String nome;
    private String sobrenome;
    private String senha;
    private String cpf;
    private List<Conta> contas;

    private Scanner scanner = new Scanner(System.in);

    public Cliente() {
        setContas();
    }

    public Cliente(Long id,String nome, String sobrenome, String cpf, String senha)
            throws SenhaInvalidaException, CpfException {
        this();
        setId(id);
        setNome(sobrenome);
        setSobrenome(sobrenome);
        setCpf(cpf);
        setSenha(senha);
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas() {
        this.contas = new ArrayList<>();
    }

    // metodos auxiliares

    private boolean validarCpf(String cpf) {
        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se tem 11 dígitos ou se é uma sequência de dígitos iguais
        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Calcula o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * (10 - i);
        }
        int primeiroDigito = 11 - (soma % 11);
        if (primeiroDigito > 9) {
            primeiroDigito = 0;
        }

        // Calcula o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * (11 - i);
        }
        int segundoDigito = 11 - (soma % 11);
        if (segundoDigito > 9) {
            segundoDigito = 0;
        }

        // Verifica se os dígitos calculados conferem com os informados
        return (cpf.charAt(9) - '0' == primeiroDigito) &&
                (cpf.charAt(10) - '0' == segundoDigito);
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

    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
        conta.setCliente(this);
    }

    public void removerConta(Conta conta) {
        this.contas.remove(conta);
        conta.setCliente(null);
    }

    // to string

    @Override
    public String toString() {
        return "Cliente:" + nome + " " + sobrenome;
    }

    

    

    

}
