package br.com.siscomanda.service;

import java.io.Serializable;

import br.com.siscomanda.enumeration.ETipoOperacao;
import br.com.siscomanda.interfaces.CalculaLancamento;
import br.com.siscomanda.model.CaixaLancamento;

public class LancamentoSaidaService implements Serializable, CalculaLancamento {
	
	private static final long serialVersionUID = -401282639514056568L;

	@Override
	public CaixaLancamento executaCalculo(CaixaLancamento lancamento, ETipoOperacao tipoOperacao, Double valor) {
		
		if(tipoOperacao.equals(ETipoOperacao.SAIDA)) {
			lancamento.setValorSaida(valor);
			lancamento.setValorEntrada(new Double(0));
		}
		
		return lancamento;
	}
}
