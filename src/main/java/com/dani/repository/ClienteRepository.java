package main.java.com.dani.repository;

import java.util.List;
import java.util.Optional;

import main.java.com.dani.model.Cliente;

public class ClienteRepository implements Repository<Cliente, String> {

    @Override
    public Cliente salvar(Cliente entity) {
        // TODO Auto-generated method stub
        return entity;
        //throw new UnsupportedOperationException("Unimplemented method 'salvar'");
    }

    @Override
    public Optional<Cliente> buscarPorId(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    @Override
    public List<Cliente> listarTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTodos'");
    }

    @Override
    public void atualizar(Cliente entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public void deletar(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletar'");
    }
    
}
