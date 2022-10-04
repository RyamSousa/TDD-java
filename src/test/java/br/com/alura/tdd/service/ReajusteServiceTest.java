package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReajusteServiceTest {

    ReajusteService service;
    Funcionario funcionario;

    @BeforeEach
    void setUp() {
        this.service = new ReajusteService();
        this.funcionario =
                new Funcionario("Nome do Func", LocalDate.now(), new BigDecimal("1000.00"));
    }

    @Test
    void reajusteDeveriaSerDe3PorCentoQuandoDesempenhoForADesejar() {
        service.reajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSerDe3PorCentoQuandoDesempenhoForBom() {
        service.reajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSerDe3PorCentoQuandoDesempenhoForOtimo() {
        service.reajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }

}