package br.com.siscomanda.base.bean;

import java.io.Serializable;

public class EstadoViewBean implements Serializable {

	private static final long serialVersionUID = -876338639656095129L;

	private Boolean update = false;
	private Boolean insert = false;
	private Boolean delete = false;
	private Boolean search = false;
	
	public EstadoViewBean() {
	}
	
	public EstadoViewBean(String stateView) {
		if("insert".equals(stateView)) {
			setInsert(true);
		}
		else if("delete".equals(stateView)) {
			setDelete(true);
		}
		else if("update".equals(stateView)) {
			setUpdate(true);
		}
		else if("search".equals(stateView)) {
			setSearch(true);
		}
	}
	
	public void setCurrentView(Boolean isInsert, Boolean isUpdate, Boolean isDelete, Boolean isSearch) {
		setSearch(isSearch);
		setUpdate(isUpdate);
		setDelete(isDelete);
		setInsert(isInsert);
	}

	public Boolean getUpdate() {
		return update;
	}

	public void setUpdate(Boolean update) {
		this.update = update;
	}

	public Boolean getInsert() {
		return insert;
	}

	public void setInsert(Boolean insert) {
		this.insert = insert;
	}

	public Boolean getDelete() {
		return delete;
	}

	public void setDelete(Boolean delete) {
		this.delete = delete;
	}

	public Boolean getSearch() {
		return search;
	}

	public void setSearch(Boolean search) {
		this.search = search;
	}

}
