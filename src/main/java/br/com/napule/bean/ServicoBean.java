package br.com.napule.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.napule.base.bean.BaseBean;
import br.com.napule.config.jsf.JSFUtil;
import br.com.napule.exception.NapuleException;
import br.com.napule.model.Servico;
import br.com.napule.service.ServicoService;

@Named
@ViewScoped
public class ServicoBean extends BaseBean<Servico> implements Serializable {

	private static final long serialVersionUID = -3066996558123931260L;
	
	@Inject
	private ServicoService servicoService;
	
	private List<Servico> servicos;
	
	private Servico servicoSelecionado;
	
	private List<Servico> servicosSelecionados;
	
	@Override 
	public void init() {
	}
	
	public void btnRemover() {
		try {
			servicoService.remover(getServicosSelecionados());
			getElements().removeAll(getServicosSelecionados());
			JSFUtil.addMessage(FacesMessage.SEVERITY_INFO, "Registro(s) removido(s) com sucesso.");
		} catch (NapuleException e) {
			JSFUtil.addMessage(FacesMessage.SEVERITY_ERROR, "Erro ao remover. " + e.getMessage());
		}
	}
	
	public void btnSalvar() {
		try {			
			servicoService.salvar(getEntity());
			setEntity(new Servico());
			getEstadoViewBean().setUpdate(false);
		}
		catch(NapuleException e) {
			JSFUtil.addMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar. " + e.getMessage());
		}
	}
	
	public void btnPesquisar() {
		try {	
			setElements(servicoService.pesquisar(getEntity()));
		}
		catch(NapuleException e) {
			JSFUtil.addMessage(FacesMessage.SEVERITY_WARN, e.getMessage());
		}
	}
	
	@Override
	protected void beforeSearch() {
		if(getEstadoViewBean().getSearch()) {
			setElements(servicoService.todos());
		}
		setEntity(new Servico());
	}

	public ServicoService getServicoService() {
		return servicoService;
	}

	public void setServicoService(ServicoService servicoService) {
		this.servicoService = servicoService;
	}

	public Servico getServicoSelecionado() {
		return servicoSelecionado;
	}

	public void setServicoSelecionado(Servico servicoSelecionado) {
		this.servicoSelecionado = servicoSelecionado;
	}

	public List<Servico> getServicosSelecionados() {
		return servicosSelecionados;
	}

	public void setServicosSelecionados(List<Servico> servicosSelecionados) {
		this.servicosSelecionados = servicosSelecionados;
	}

	public List<Servico> getServicos() {
		return servicos;
	}
}
