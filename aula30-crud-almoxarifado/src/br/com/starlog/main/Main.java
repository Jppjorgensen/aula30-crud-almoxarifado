package br.com.starlog.main;

import br.com.starlog.dao.ProdutoDAO;
import br.com.starlog.dao.ProdutoDAOSqlite;
import br.com.starlog.model.Produto;

import java.util.Locale;

/**
 * Ciclo completo do CRUD pedido na lista da Aula 30.
 */
public class Main {

    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAOSqlite();

        // [Create]
        Produto teclado = new Produto("Teclado Mecânico RGB", 249.90, 10);
        Produto mousepad = new Produto("Mousepad Speed XL", 79.90, 30);
        dao.salvar(teclado);
        dao.salvar(mousepad);
        System.out.println("[Create] IDs gerados: teclado=" + teclado.getId() + ", mousepad=" + mousepad.getId());

        // [Read]
        System.out.println("\n[Read] Catálogo:");
        imprimirCatalogo(dao);

        // [Update]
        teclado.setEstoque(15);
        teclado.setPreco(289.90);
        boolean atualizou = dao.atualizar(teclado);
        System.out.println("\n[Update] Atualizou o teclado? " + atualizou);
        dao.buscarPorId(teclado.getId()).ifPresent(p -> System.out.println("Registro atualizado: " + p));

        // [Delete]
        boolean excluiuMousepad = dao.excluir(mousepad.getId());
        System.out.println("\n[Delete] Excluiu o mousepad? " + excluiuMousepad);
        boolean excluiuInexistente = dao.excluir(888L);
        if (excluiuInexistente) {
            System.out.println("Produto 888 excluído.");
        } else {
            System.out.println("Produto 888 não existe; nada foi excluído e o sistema continua normalmente.");
        }

        // [Final State]
        System.out.println("\n[Final] Catálogo final - total de produtos: " + dao.listarTodos().size());
        imprimirCatalogo(dao);
    }

    private static void imprimirCatalogo(ProdutoDAO dao) {
        System.out.printf("%-4s | %-22s | %10s | %7s%n", "ID", "NOME", "PREÇO", "ESTOQUE");
        for (Produto p : dao.listarTodos()) {
            System.out.printf(Locale.US, "%-4d | %-22s | R$ %7.2f | %7d%n", p.getId(), p.getNome(), p.getPreco(), p.getEstoque());
        }
    }
}
