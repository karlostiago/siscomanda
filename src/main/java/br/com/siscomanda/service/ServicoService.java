package br.com.siscomanda.service;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.inject.Inject;

import br.com.siscomanda.config.jpa.Transactional;
import br.com.siscomanda.exception.SiscomandaException;
import br.com.siscomanda.model.Servico;
import br.com.siscomanda.repository.dao.ServicoDAO;
import br.com.siscomanda.util.JSFUtil;
import br.com.siscomanda.util.StringUtil;

public class ServicoService implements Serializable {


	private static final long serialVersionUID = -2167240798275553918L;
		
	@Inject
	private ServicoDAO dao;
	
	public List<Servico> pesquisar(Servico servico) throws SiscomandaException {
		List<Servico> list = null;
		if(list == null && !servico.getDescricao().isEmpty()) {
			list = dao.porDescricao(servico.getDescricao(), Servico.class);
		}
		
		if(list == null) {
			list = todos();
		}
				
		return list;
	}
	
	@Transactional
	public Servico salvar(Servico servico) throws SiscomandaException {
		servico = validacao(servico);
		
		if(servico.isNovo()) {
			servico = dao.salvar(servico);
			JSFUtil.addMessage(FacesMessage.SEVERITY_INFO, "Registro salvo com sucesso.");
			
			return servico;
		}
		
		JSFUtil.addMessage(FacesMessage.SEVERITY_INFO, "Registro alterado com sucesso.");
		return dao.salvar(servico);
	}
	
	private Servico validacao(Servico servico) throws SiscomandaException {
		if(StringUtil.isEmpty(servico.getDescricao())) {
			throw new SiscomandaException("É necessário informar uma descrição para este serviço.!");
		}
		
		if(servico.isNovo()) {
			if(dao.isExists(servico.getDescricao(), Servico.class)) {
				throw new SiscomandaException("Esse serviço já se encontra cadastro no sistema.!");
			}
		}
		
		return servico;
	}
	
	public List<Servico> todos() {
		return dao.todos(Servico.class);
	}
	
	@Transactional
	public void remover(List<Servico> servicos) throws SiscomandaException {
		if(servicos == null || servicos.isEmpty()) {
			throw new SiscomandaException("Selecione pelo menos 1 registro para ser excluído.!");
		}
		
		try {
			for(Servico servico : servicos) {
				dao.remover(Servico.class, servico.getId());
			}
		}
		catch(SiscomandaException e) {
			throw new SiscomandaException(e.getMessage(), e);
		}
	}
}
