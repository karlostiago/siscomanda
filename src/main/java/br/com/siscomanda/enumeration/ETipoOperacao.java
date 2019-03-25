package br.com.siscomanda.enumeration;

public enum ETipoOperacao {
	
	VENDA("Venda - Lançamento gerado de uma venda"),
	DESPESA("Saída - Lançamento de despesas"),
	SAIDA("Saída - Sangria"),
	ENTRADA("Entrada - Acrescímo");
	
	private String descricao;
	
	private ETipoOperacao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
