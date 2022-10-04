package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ReajusteService {

    void reajuste(Funcionario funcionario, Desempenho desempenho) {
        BigDecimal percentualReajuste = desempenho.percentualReajuste();
        BigDecimal aumento = funcionario.getSalario()
                .multiply(percentualReajuste);
        funcionario.reajuste(aumento);
    }
}
