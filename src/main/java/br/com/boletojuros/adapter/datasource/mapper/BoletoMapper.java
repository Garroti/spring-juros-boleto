package br.com.boletojuros.adapter.datasource.mapper;

import org.mapstruct.Mapper;

import br.com.boletojuros.adapter.datasource.integration.dto.BoletoDTO;
import br.com.boletojuros.core.domain.Boleto;

@Mapper(componentModel = "spring")
public interface BoletoMapper {
	Boleto toDomain(BoletoDTO boletoDTO);
}
