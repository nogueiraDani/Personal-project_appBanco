package main.java.com.dani.repository;

import java.util.List;
import java.util.Optional;

import main.java.com.dani.model.Conta;

public class ContaRepository implements Repository<Conta, String>{

    @Override
    public Conta salvar(Conta entity) {
        // TODO Auto-generated method stub
        return entity;
    }

    @Override
    public Optional<Conta> buscarPorId(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    @Override
    public List<Conta> listarTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTodos'");
    }

    @Override
    public void atualizar(Conta entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public void deletar(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletar'");
    }

}
