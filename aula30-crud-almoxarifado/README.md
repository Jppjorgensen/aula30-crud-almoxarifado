# Aula 30 — CRUD completo (Almoxarifado StarLog)

`Produto` com validações, interface `ProdutoDAO` com as 5 operações e `ProdutoDAOSqlite` (`atualizar` e `excluir` retornam `linhasAfetadas > 0`, `listarTodos` com `ORDER BY nome ASC`). O `Main` faz o ciclo Create, Read, Update, Delete.

## Como rodar

Abra o terminal na pasta do projeto (onde está este README). É preciso ter o JDK 17 ou superior.

**macOS / Linux**

```bash
javac -encoding UTF-8 -cp "lib/*" -sourcepath src -d bin src/br/com/starlog/main/Main.java
java -cp "bin:lib/*" br.com.starlog.main.Main
```

**Windows**

```bat
javac -encoding UTF-8 -cp "lib/*" -sourcepath src -d bin src\br\com\starlog\main\Main.java
java -cp "bin;lib/*" br.com.starlog.main.Main
```

## Resultado esperado

O teclado fica com preço 289.90 e estoque 15, o mousepad é excluído, o ID 888 retorna `false` sem travar e sobra 1 produto. Para repetir do zero, apague o arquivo `almoxarifado.db`.
