package com.sofmit.fits.common.utils.pager;

import java.io.Serializable;


public class QueryParams implements Serializable {

	private static final long serialVersionUID = 5929679884611867275L;
	private Integer page=1;
	private Integer rows=10;
	private String sort = "1";
	private String order = "asc";

	public Integer getPage() { 
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

}
