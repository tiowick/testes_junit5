package JUNIT5_Direct;
import JUNIT_5.Conexao_bd;
import JUNIT_5.Pessoa;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

public class AfterBeforeTest {
    @BeforeAll
    static void configuraConexao() {
        Conexao_bd.iniciarConexao();
    }

    @BeforeEach
    void insereDadosParaTeste() {
        Conexao_bd.insereDados(new Pessoa("João", LocalDateTime.of(2000, 1, 1, 13, 0, 0)));
    }

    @AfterEach
    void removeDadosDoTeste() {
        Conexao_bd.removeDados(new Pessoa("João", LocalDateTime.of(2000, 1, 1, 13, 0, 0)));
    }

    @Test
    void validarDadosDeRetorno() {
        Assertions.assertTrue(true);
    }

    @Test
    void validarDadosDeRetorno2() {
        Assertions.assertNull(null);
    }

    @AfterAll
    static void finalizarConexao() {
        Conexao_bd.finalizarConexao();
    }
}
