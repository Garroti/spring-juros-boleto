package br.com.boletojuros.adapter.datasource.integration;

import br.com.boletojuros.adapter.datasource.integration.client.ComplementoBoletoClient;
import br.com.boletojuros.adapter.datasource.mapper.BoletoMapper;
import br.com.boletojuros.core.domain.Boleto;
import br.com.boletojuros.core.port.out.ComplementarBoletoPort;
import org.springframework.stereotype.Component;

@Component
public class ComplementoBoletoIntegration implements ComplementarBoletoPort {

	private final BoletoMapper mapper;
	private final ComplementoBoletoClient client;

	public ComplementoBoletoIntegration(BoletoMapper mapper, ComplementoBoletoClient client) {
		this.mapper = mapper;
		this.client = client;
	}

	@Override
	public Boleto executar(String codigo) {
		var boletoDTO = client.getBoleto(codigo);
		return mapper.toDomain(boletoDTO);
	}
}
