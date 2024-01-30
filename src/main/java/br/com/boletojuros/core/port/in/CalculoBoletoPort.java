package br.com.boletojuros.core.port.in;

import java.time.LocalDate;

import br.com.boletojuros.core.domain.BoletoCalculado;

public interface CalculoBoletoPort {
	BoletoCalculado executar(String codigo, LocalDate dataPagamento);
}
