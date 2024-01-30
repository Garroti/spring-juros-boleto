package br.com.boletojuros.core.exceptions;

import br.com.boletojuros.core.domain.enums.TipoExcecao;

public class ApplicationException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private TipoExcecao tipoExcecao;
	
	public ApplicationException() {}

	public ApplicationException(TipoExcecao tipoExcecao) {
		super();
		this.tipoExcecao = tipoExcecao;
	}

	public TipoExcecao getTipoExcecao() {
		return tipoExcecao;
	}

	public void setTipoExcecao(TipoExcecao tipoExcecao) {
		this.tipoExcecao = tipoExcecao;
	}
	
}
