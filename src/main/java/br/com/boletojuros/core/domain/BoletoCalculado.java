package br.com.boletojuros.core.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.boletojuros.core.domain.enums.TipoBoleto;

public class BoletoCalculado {
	
	private String codigo;
	private BigDecimal valorOriginal;
	private BigDecimal valor;
	private LocalDate dataVencimento;
	private LocalDate dataPagamento;
	private BigDecimal juros;
	private TipoBoleto tipo;
	
	public BoletoCalculado() {}

	public BoletoCalculado(String codigo, BigDecimal valorOriginal, BigDecimal valor, LocalDate dataVencimento,
			LocalDate dataPagamento, BigDecimal juros, TipoBoleto tipo) {
		super();
		this.codigo = codigo;
		this.valorOriginal = valorOriginal;
		this.valor = valor;
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
		this.juros = juros;
		this.tipo = tipo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getValorOriginal() {
		return valorOriginal;
	}

	public void setValorOriginal(BigDecimal valorOriginal) {
		this.valorOriginal = valorOriginal;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public BigDecimal getJuros() {
		return juros;
	}

	public void setJuros(BigDecimal juros) {
		this.juros = juros;
	}

	public TipoBoleto getTipo() {
		return tipo;
	}

	public void setTipo(TipoBoleto tipo) {
		this.tipo = tipo;
	}

}
