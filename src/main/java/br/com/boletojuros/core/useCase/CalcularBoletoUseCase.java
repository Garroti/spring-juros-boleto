package br.com.boletojuros.core.useCase;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.boletojuros.core.domain.Boleto;
import br.com.boletojuros.core.domain.BoletoCalculado;
import br.com.boletojuros.core.domain.enums.TipoBoleto;
import br.com.boletojuros.core.domain.enums.TipoExcecao;
import br.com.boletojuros.core.exceptions.ApplicationException;
import br.com.boletojuros.core.port.in.CalculoBoletoPort;
import br.com.boletojuros.core.port.out.ComplementarBoletoPort;
import br.com.boletojuros.core.port.out.SalvarCalculoBoletoPort;

@Service
public class CalcularBoletoUseCase implements CalculoBoletoPort {
	
	private static final BigDecimal JUROS_DIARIO = BigDecimal.valueOf(0.033);
	
	@Autowired
	private ComplementarBoletoPort complementoBoletoPort;
	
	@Autowired
	private SalvarCalculoBoletoPort salvarCalculoBoletoPort;

	@Override
	public BoletoCalculado executar(String codigo, LocalDate dataPagamento) {
		
		var boleto = complementoBoletoPort.executar(codigo);
		
		validar(boleto);
		
		var diasVencidos = getDiasVencidos(boleto.getDataVencimento(), dataPagamento);
		var valorJurosDia = JUROS_DIARIO.multiply(boleto.getValor()).divide(BigDecimal.valueOf(100));
		var juros = valorJurosDia.multiply(BigDecimal.valueOf(diasVencidos)).setScale(2, RoundingMode.HALF_EVEN);
		BoletoCalculado boletoCalculado = new BoletoCalculado(boleto.getCodigo(), boleto.getValor(), boleto.getValor().add(juros), boleto.getDataVencimento(),
				dataPagamento, juros, boleto.getTipo());
		
		salvarCalculoBoletoPort.executar(boletoCalculado);
		
		return boletoCalculado;
	}
	
	private void validar(Boleto boleto) {
		if(boleto == null) {
			throw new ApplicationException(TipoExcecao.BOLETO_INVALIDO);
		}
		
		if(boleto.getTipo() != TipoBoleto.XPTO) {
			throw new ApplicationException(TipoExcecao.TIPO_BOLETO_INVALIDO);
		}
		
		if(boleto.getDataVencimento().isAfter(LocalDate.now())) {
			throw new ApplicationException(TipoExcecao.BOLETO_NÃO_VENCIDO);
		}
	}
	
	private Long getDiasVencidos(LocalDate dataVencimento, LocalDate dataPagamento) {
		return ChronoUnit.DAYS.between(dataVencimento, dataPagamento);
	}

}
