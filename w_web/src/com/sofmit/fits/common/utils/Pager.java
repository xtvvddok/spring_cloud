package com.sofmit.fits.common.utils;

import java.util.List;
import java.util.Map;

public class Pager<T> {

	private int pageNo;

	private int pageSize;

	private int totalPages;

	private int totalRows;

	private List<T> rows;
	
	private List<Map<String, Object>> rowsMap;
	

	public Pager() {
	}

	public Pager(int pageNo, int pageSize, int totalRows) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalRows = totalRows;

		if (this.pageNo < 1) {
			this.pageNo = 1;
		}
		if (this.pageSize < 1) {
			this.pageSize = 1;
		}

		this.totalPages = (this.totalRows + this.pageSize - 1) / this.pageSize;
		if (this.pageNo >= this.totalPages) {
			this.pageNo = this.totalPages;
		}
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public List<Map<String, Object>> getRowsMap() {
		return rowsMap;
	}

	public void setRowsMap(List<Map<String, Object>> list) {
		this.rowsMap = list;
	}

}
