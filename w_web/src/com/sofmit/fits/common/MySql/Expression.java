package com.sofmit.fits.common.MySql;

public class Expression {
	
	private String column;
	
	private static final String LIKE = "like";
	
	private static final String NOT_LIKE = "not like";
	
	private static final String IS_NULL = "is null";
	
	private static final String IS_NOT_NULL = "is not null";
	
	private static final String NOT_EQUAL = "<>";
	
	private static final String IN = "in";
	
	private static final String NO_TIN = "not in";
	//小于
	private static final String LT = "<";
	//小于等于
	private static final String LT_EQUAL = "<=";
	//大于
	private static final String GT = ">";
	//大于等于
	private static final String GT_EQUAL = ">=";
	
	private String value;
	

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	
	

}
