package br.com.boletojuros.adapter.datasource.integration.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.boletojuros.core.domain.enums.TipoBoleto;

public class BoletoDTO {
	
	private String codigo;
	
	@JsonProperty("data_vencimento")
	private LocalDate dataVencimento;
	
	private BigDecimal valor;
	
	private TipoBoleto tipo;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoBoleto getTipo() {
		return tipo;
	}

	public void setTipo(TipoBoleto tipo) {
		this.tipo = tipo;
	}

}
