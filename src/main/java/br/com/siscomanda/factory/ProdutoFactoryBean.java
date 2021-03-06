package br.com.siscomanda.factory;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.siscomanda.exception.SiscomandaException;
import br.com.siscomanda.model.Produto;
import br.com.siscomanda.service.ProdutoService;

@Named
@ViewScoped
public class ProdutoFactoryBean implements Serializable {

	private static final long serialVersionUID = -2485891672023525149L;
	
	private List<Produto> produtos;
	
	private String pesquisar;
	
	@Inject
	private ProdutoService service;
	
	@PostConstruct
	public void init() {
		produtos = service.todos();
	}
	
	public void ajaxPesquisar() {
		Produto produto = new Produto();

		try {
			
			produto.setCodigoEan(null);
			produto.setDescricao(pesquisar);
			List<Produto> produtos = service.pesquisar(produto);
			if(produtos == null || produtos.isEmpty()) {
				produto.setDescricao(null);
				produto.setCodigoEan(pesquisar);
				produtos = service.pesquisar(produto);
			}
			if(!produtos.isEmpty()) {
				this.produtos = produtos;
			}
			
			
		} catch (SiscomandaException e) {
			e.printStackTrace();
		}
		finally {
			pesquisar = null;
			produto.setCodigoEan(null);
			produto.setDescricao(null);
		}
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public String getPesquisar() {
		return pesquisar;
	}

	public void setPesquisar(String pesquisar) {
		this.pesquisar = pesquisar;
	}
}
