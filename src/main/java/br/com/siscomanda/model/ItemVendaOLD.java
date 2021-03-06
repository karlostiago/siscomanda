package br.com.siscomanda.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.siscomanda.base.model.BaseEntity;

//@Entity
//@Table(name = "item_venda")
public class ItemVendaOLD extends BaseEntity implements Serializable, Comparable<ItemVendaOLD> {

	private static final long serialVersionUID = 7754528961077613833L;
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "produto_id", nullable = false)
	private Produto produto;
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "venda_id", nullable = false)
	private VendaOLD venda;
		
//	@Column(name = "quantidade", nullable = false)
	private Double quantidade;
	
//	@Column(name = "subtotal", nullable = false)
	private Double subtotal;
	
//	@Column(name = "preco_venda", nullable = false)
	private Double precoVenda;
	
//	@Column(name = "observacao")
	private String observacao;
	
//	@Transient
	private List<Adicional> adicionais = new ArrayList<Adicional>();
		
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	
	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}
	
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public List<Adicional> getAdicionais() {
		return adicionais;
	}

	public void setAdicionais(List<Adicional> adicionais) {
		this.adicionais = adicionais;
	}
	
	public VendaOLD getVenda() {
		return venda;
	}

	public void setVenda(VendaOLD venda) {
		this.venda = venda;
	}

	@Override
	public int compareTo(ItemVendaOLD o) {
		if(this.getId() < o.getId()) {
			return -1;
		}
		return 0;
	}
}
