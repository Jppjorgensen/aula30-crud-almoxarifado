package br.com.starlog.dao;

import br.com.starlog.model.Produto;

import java.util.List;
import java.util.Optional;

/**
 * As 5 operações do CRUD, sem nenhum detalhe de banco.
 */
public interface ProdutoDAO {

    void salvar(Produto produto);

    Optional<Produto> buscarPorId(Long id);

    List<Produto> listarTodos();

    boolean atualizar(Produto produto);

    boolean excluir(Long id);
}
