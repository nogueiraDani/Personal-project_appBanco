package main.java.com.dani.repository;

import java.util.List;
import java.util.Optional;

// Interface genérica para repositórios
public interface Repository<T, ID> {
    T salvar(T entity);

    Optional<T> buscarPorId(ID id);

    List<T> listarTodos();

    void atualizar(T entity);

    void deletar(ID id);
}

