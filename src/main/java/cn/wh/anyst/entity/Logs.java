package cn.wh.anyst.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

/*
 * 日志实体对象
 */

@Entity
@Table(name = "anyst_logs")
public class Logs extends IdEntity {
	private int type;			//日志类型
	private String content;		//日志内容
	private Date date;			//日志时间
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
