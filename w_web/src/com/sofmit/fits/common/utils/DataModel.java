package com.sofmit.fits.common.utils;

import java.util.List;
import java.util.Map;

public class DataModel {
	
	private List<Map<String,Object>> rows;
	
//	private List<String> searchList;

	private long total;


	
	public DataModel() {
	}


	public DataModel(List<Map<String, Object>> rows, long total) {
		this.rows = rows;
		this.total = total;
	}
	
	public List<Map<String, Object>> getRows() {
		return rows;
	}


	public void setRows(List<Map<String, Object>> rows) {
		this.rows = rows;
	}


	public long getTotal() {
		return total;
	}


	public void setTotal(long total) {
		this.total = total;
	}


	
	
}
