package com.sofmit.fits.common.utils.hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.IteratorUtils;
import org.apache.commons.lang.StringUtils;

public class HPage<T> implements Serializable {
	private static final long serialVersionUID = -963181732889414069L;
	// -- 公共变量 --//
	public static final String ASC = "asc";
	public static final String DESC = "desc";
	public static final int DEFAULT_PAGE_SIZE = 10;

	// -- 分页查询参数 --//
	protected Integer pageNo = 1;
	protected Integer pageSize = -1;
	protected boolean autoCount = true;
	protected String orderBy = null;
	protected String order = null;

	// -- 返回结果 --//
	protected List<T> result = new ArrayList<T>(10);
	protected Long totalItems = 0L;
	protected Long totalPages = -1L;

	// -- 构�?�函�? --//
	public HPage() {
		setPageSize(DEFAULT_PAGE_SIZE);
	}

	public HPage(Integer pageSize) {
		setPageSize(pageSize);
	}

	public HPage(Integer pageNo, Integer pageSize) {
		if (pageNo == null)
			pageNo = 1;
		if (pageSize == null)
			pageSize = DEFAULT_PAGE_SIZE;
		setPageNo(pageNo);
		setPageSize(pageSize);
	}

	// -- 分页参数访问函数 --//
	/**
	 * 获得当前页的页号,序号�?1�?�?,默认�?1.
	 */
	public Integer getPageNo() {
		return pageNo;
	}

	/**
	 * 设置当前页的页号,序号�?1�?�?,低于1时自动调整为1.
	 */
	public void setPageNo(final Integer pageNo) {
		this.pageNo = pageNo;

		if (pageNo == null || pageNo < 1) {
			this.pageNo = 1;
		}
	}

	/**
	 * 获得每页的记录数�?, 默认�?-1.
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * 设置每页的记录数�?.
	 */
	public void setPageSize(final Integer pageSize) {
		this.pageSize = pageSize;
		
		if (this.pageSize == null)
			this.pageSize = DEFAULT_PAGE_SIZE;
	}

	/**
	 * 获得排序字段,无默认�??. 多个排序字段时用','分隔.
	 */
	public String getOrderBy() {
		return orderBy;
	}

	/**
	 * 设置排序字段,多个排序字段时用','分隔.
	 */
	public void setOrderBy(final String orderBy) {
		this.orderBy = orderBy;
	}

	/**
	 * 获得排序方向, 无默认�??.
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * 设置排序方式�?.
	 * 
	 * @param order
	 *            可�?��?�为desc或asc,多个排序字段时用','分隔.
	 */
	public void setOrder(final String order) {
		String lowcaseOrder = StringUtils.lowerCase(order);

		// �?查order字符串的合法�?
		String[] orders = StringUtils.split(lowcaseOrder, ',');
		if (orders!=null){
			for (String orderStr : orders) {
				if (!StringUtils.equals(DESC, orderStr) && !StringUtils.equals(ASC, orderStr)) {
					throw new IllegalArgumentException("排序方向" + orderStr + "不是合法�?");
				}
			}
		}
		
		this.order = lowcaseOrder;
	}

	/**
	 * 是否已设置排序字�?,无默认�??.
	 */
	public boolean hasOrderBy() {
		return (StringUtils.isNotBlank(orderBy) && StringUtils.isNotBlank(order));
	}

	/**
	 * 根据pageNo和pageSize计算当前页第�?条记录在总结果集中的位置,序号�?0�?�?. 用于Mysql,Hibernate.
	 */
	public int offset() {
		return ((pageNo - 1) * pageSize);
	}

	/**
	 * 根据pageNo和pageSize计算当前页第�?条记录在总结果集中的位置,序号�?1�?�?. 用于Oracle.
	 */
	public int startRow() {
		return offset() + 1;
	}

	/**
	 * 根据pageNo和pageSize计算当前页最后一条记录在总结果集中的位置, 序号�?1�?�?. 用于Oracle.
	 */
	public int endRow() {
		return pageSize * pageNo;
	}

	// -- 访问查询结果函数 --//

	/**
	 * 获得页内的记录列�?.
	 */
	public List<T> getResult() {
		return result;
	}

	/**
	 * 设置页内的记录列�?.
	 */
	public void setResult(final List<T> result) {
		this.result = result;
	}

	/**
	 * 实现Iterable接口,可以for(Object item : page)遍历使用
	 */
	@SuppressWarnings("unchecked")
	public Iterator<T> iterator() {
		return result == null ? IteratorUtils.EMPTY_ITERATOR : result.iterator();
	}

	/**
	 * 获得总记录数, 默认值为-1.
	 */
	public long getTotalItems() {
		return totalItems;
	}

	/**
	 * 设置总记录数.
	 */
	public void setTotalItems(final Long totalItems) {
		this.totalItems = totalItems;
	}

//	/**
//	 * 是否�?后一�?.
//	 */
//	public boolean isLastPage() {
//		return pageNo == getTotalPages().intValue();
//	}

	/**
	 * 是否还有下一�?.
	 */
	public boolean hasNextPage() {
		return (pageNo + 1 <= getTotalPages());
	}

	/**
	 * 取得下页的页�?, 序号�?1�?�?. 当前页为尾页时仍返回尾页序号.
	 */
	public int nextPage() {
		if (hasNextPage()) {
			return pageNo + 1;
		} else {
			return pageNo;
		}
	}

//	/**
//	 * 是否第一�?.
//	 */
//	public boolean isFirstPage() {
//		return pageNo == 1;
//	}

	/**
	 * 是否还有上一�?.
	 */
	public boolean hasPrePage() {
		return (pageNo - 1 >= 1);
	}

	/**
	 * 取得上页的页�?, 序号�?1�?�?. 当前页为首页时返回首页序�?.
	 */
	public int prePage() {
		if (hasPrePage()) {
			return pageNo - 1;
		} else {
			return pageNo;
		}
	}

	/**
	 * 根据pageSize与totalItems计算总页�?, 默认值为-1.
	 */
	public Long getTotalPages() {
		if (totalItems < 0) {
			totalPages = -1L;
			return totalPages;
		}

		totalPages = totalItems / pageSize;
		if (totalItems % pageSize > 0) {
			totalPages++;
		}
		return totalPages;
	}


	public void setTotalPages(Long totalPages) {
		this.totalPages = totalPages;
	}
	
	public void setAutoCount(boolean autoCount) {
		this.autoCount = autoCount;
	}


	public boolean isAutoCount(){
		return autoCount;
	}

}
