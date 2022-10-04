package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BonusServiceTest {

    BonusService service;

    @BeforeEach
    void setup(){
        this.service = new BonusService();
    }

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> service.calcularBonus(
                        new Funcionario(
                                "Nome do funcionário", LocalDate.now(), new BigDecimal("25000")
                        )
                )
        );
    }

    @Test
    void bonusDeveriaSer10PorCentoDoSalario() {
        BigDecimal bonus = service.calcularBonus(
                new Funcionario(
                        "Nome do funcionário", LocalDate.now(), new BigDecimal("2500")
                )
        );
        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusDeveriaSer10PorCentoParaSalarioDoExatamente10000() {
        BigDecimal bonus = service.calcularBonus(
                new Funcionario(
                        "Nome do funcionário", LocalDate.now(), new BigDecimal("10000")
                )
        );
        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}