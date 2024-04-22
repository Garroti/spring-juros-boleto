package br.com.boletojuros.core.domain.enums;

public enum TipoExcecao {
	BOLETO_INVALIDO {
		@Override
		public String getMensagemErro() {
			return "O boleto encontrado é invalido";
		}
	},
	TIPO_BOLETO_INVALIDO {
		@Override
		public String getMensagemErro() {
			return "Infelizmente so podemos calcular o juros do boleto XPTO";
		}
	},
	BOLETO_NÃO_VENCIDO {
		@Override
		public String getMensagemErro() {
			return "O boleto informado ainda não esta vencido";
		}
	},
	CONTEUDO_INVALIDO {
		@Override
		public String getMensagemErro() {
			return "Conteudo inválido";
		}
	};
	
	public abstract String getMensagemErro();
}
