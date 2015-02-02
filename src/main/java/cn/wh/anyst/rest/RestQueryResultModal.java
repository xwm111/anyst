package cn.wh.anyst.rest;

import java.util.List;

/*
 * 批量查询结果返回对象
 */
public class RestQueryResultModal<T> {
	private long total;
	private List<T> rows;
	public RestQueryResultModal(long total, List<T> rows) {
		this.total = total;
		this.rows = rows;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
