package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ReajusteService {

    void reajuste(Funcionario funcionario, Desempenho desempenho){
        if (desempenho == Desempenho.A_DESEJAR){
            BigDecimal aumento = funcionario.getSalario()
                    .multiply(new BigDecimal("0.03")).setScale(2, RoundingMode.HALF_UP);
            funcionario.reajuste(aumento);
        }
        if (desempenho == Desempenho.BOM){
            BigDecimal aumento = funcionario.getSalario()
                    .multiply(new BigDecimal("0.15")).setScale(2, RoundingMode.HALF_UP);
            funcionario.reajuste(aumento);
        }
        if (desempenho == Desempenho.OTIMO){
            BigDecimal aumento = funcionario.getSalario()
                    .multiply(new BigDecimal("0.20")).setScale(2, RoundingMode.HALF_UP);
            funcionario.reajuste(aumento);
        }
    }
}
