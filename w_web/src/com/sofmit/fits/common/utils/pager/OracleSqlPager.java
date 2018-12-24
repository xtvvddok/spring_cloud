package com.sofmit.fits.common.utils.pager;

public class OracleSqlPager implements ISqlPager {

	@Override
	public String getLimitSqlString(String sql, int pageNo, int pageSize,String order) {
		boolean hasOffset = pageNo > 0 && pageSize > 0;
		int offset = (pageNo - 1) * pageSize;
		int limit = pageSize * pageNo;

		sql = sql.trim();
		String forUpdateClause = null;
		boolean isForUpdate = false;
		final int forUpdateIndex = sql.toLowerCase().lastIndexOf("for update");
		if (forUpdateIndex > -1) {
			// save 'for update ...' and then remove it
			forUpdateClause = sql.substring(forUpdateIndex);
			sql = sql.substring(0, forUpdateIndex - 1);
			isForUpdate = true;
		}

		StringBuilder pagingSelect = new StringBuilder(sql.length() + 100);
		if (hasOffset) {
			pagingSelect
					.append("select * from ( select row_.*, rownum rownum_ from ( ");
		} else {
			pagingSelect.append("select * from ( ");
		}
		pagingSelect.append(sql);
		if(order!=null){
			pagingSelect.append(" order by ").append(order);
		}
		if (hasOffset) {
			pagingSelect.append(" ) row_ where rownum <=").append(limit)
					.append(") where rownum_ > ").append(offset);
		} else {
			pagingSelect.append(" ) where rownum <= ").append(pageSize);
		}

		if (isForUpdate) {
			pagingSelect.append(" ");
			pagingSelect.append(forUpdateClause);
		}
		return pagingSelect.toString();
	}

	
}
