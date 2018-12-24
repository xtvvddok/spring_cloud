package com.sofmit.fits.common.utils;

import java.util.List;
import java.util.Map;

public class EasyUIDataModel<T> {

	private List<T> rows;
	
	private Long total;
	
	private Integer totalPage;
	
	private Integer totalRows =10;
	
	private Integer pageNo=1;

	public EasyUIDataModel() {

	}

	public EasyUIDataModel(List<T> rows, Long total) {
		this.rows = rows;
		this.total = total;
	}
	


	/**
	 * @return the rows
	 */
	public List<T> getRows() {
		return rows;
	}

	/**
	 * @param rows
	 *            the rows to set
	 */
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
	/**
	 * @return the total
	 */
	public long getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(long total) {
		this.total = total;
	}
	
	

	public Integer getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
	}

	public Integer getTotalPage() {
		
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	
	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	@Override
	public String toString() {
		return "EasyUIDataModel [rows=" + rows + ", total=" + total
				+ ", totalPage=" + totalPage + ", pageNo=" + pageNo + "]";
	}


	
}
