package br.com.siscomanda.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.siscomanda.base.model.BaseEntity;

@Entity
@Table(name = "conta_pagar")
public class ContaPagar extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 9086450591305182894L;

	private String descricao;

	private Date dataPagamento;

	private Date dataVencimento;

	private Boolean pago;

	private Double valor;

	private Double juros;

	private Double desconto;

	private Double totalPago;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Boolean getPago() {
		return pago;
	}

	public void setPago(Boolean pago) {
		this.pago = pago;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getJuros() {
		return juros;
	}

	public void setJuros(Double juros) {
		this.juros = juros;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Double getTotalPago() {
		return totalPago;
	}

	public void setTotalPago(Double totalPago) {
		this.totalPago = totalPago;
	}
}
