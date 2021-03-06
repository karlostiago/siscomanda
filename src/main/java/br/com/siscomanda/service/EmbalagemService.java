package br.com.siscomanda.service;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.inject.Inject;

import br.com.siscomanda.config.jpa.Transactional;
import br.com.siscomanda.exception.SiscomandaException;
import br.com.siscomanda.model.Embalagem;
import br.com.siscomanda.repository.dao.EmbalagemDAO;
import br.com.siscomanda.util.JSFUtil;
import br.com.siscomanda.util.StringUtil;

public class EmbalagemService implements Serializable {

	private static final long serialVersionUID = -2167240798275553918L;
		
	@Inject
	private EmbalagemDAO dao;
	
	public List<Embalagem> pesquisar(Embalagem embalagem) throws SiscomandaException {
		List<Embalagem> list = null;
		if(list == null && !embalagem.getDescricao().isEmpty()) {
			list = dao.porDescricao(embalagem.getDescricao(), Embalagem.class);
		}
		
		if(list == null) {
			list = todos();
		}
				
		return list;
	}
	
	@Transactional
	public Embalagem salvar(Embalagem embalagem) throws SiscomandaException {
		embalagem = validacao(embalagem);
		if(embalagem.isNovo()) {
			embalagem = dao.salvar(embalagem);
			JSFUtil.addMessage(FacesMessage.SEVERITY_INFO, "Registro salvo com sucesso.");
			
			return embalagem;
		}
		
		JSFUtil.addMessage(FacesMessage.SEVERITY_INFO, "Registro alterado com sucesso.");
		return dao.salvar(embalagem);
	}
	
	private Embalagem validacao(Embalagem embalagem) throws SiscomandaException {
		if(StringUtil.isEmpty(embalagem.getDescricao())) {
			throw new SiscomandaException("É necessário informar uma descrição para a embalagem.!");
		}
		
		if(embalagem.isNovo()) {
			if(dao.isExists(embalagem)) {
				throw new SiscomandaException("Essa embalagem já se encontra cadastro no sistema.!");
			}
		}
		
		return embalagem;
	}
	
	public List<Embalagem> todos() {
		return dao.todos(Embalagem.class);
	}
	
	@Transactional
	public void remover(List<Embalagem> embalagens) throws SiscomandaException {
		if(embalagens == null || embalagens.isEmpty()) {
			throw new SiscomandaException("Selecione pelo menos 1 registro para ser excluído.!");
		}
		
		try {
			for(Embalagem embalagem : embalagens) {
				dao.remover(Embalagem.class, embalagem.getId());
			}
		}
		catch(SiscomandaException e) {
			throw new SiscomandaException(e.getMessage(), e);
		}
	}
}
