package com.sofmit.fits.bean;
import java.util.Date;
import java.sql.*;
import java.math.*;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Column;
@Entity
@Table(name = "news")
public class News {
	//
	private String id;
	//
	private String title;
	//
	private String navigational;
	//
	private String topimage;
	//
	private Integer status;
	//
	private Integer sort;
	//
	private Date create_time;
	//
	private Date update_time;
	//
	private Date pub_time;
	//
	private String pub_user;
	//
	private String create_user;
	//
	private String city_code;

	@Id
	@GenericGenerator(name = "sys_id", strategy = "uuid")
	@GeneratedValue(generator = "sys_id")
	@Column(columnDefinition = "varchar(32)", name = "id", nullable = false)
	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id=id;
	}
	@Column(columnDefinition = "varchar(200)", name = "title")
	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title=title;
	}
	@Column(columnDefinition = "varchar(200)", name = "navigational")
	public String getNavigational(){
		return navigational;
	}

	public void setNavigational(String navigational){
		this.navigational=navigational;
	}
	@Column(columnDefinition = "varchar(200)", name = "topimage")
	public String getTopimage(){
		return topimage;
	}

	public void setTopimage(String topimage){
		this.topimage=topimage;
	}
	@Column(columnDefinition = "int", name = "status")
	public Integer getStatus(){
		return status;
	}

	public void setStatus(Integer status){
		this.status=status;
	}
	@Column(columnDefinition = "int", name = "sort")
	public Integer getSort(){
		return sort;
	}

	public void setSort(Integer sort){
		this.sort=sort;
	}
	@Column(columnDefinition = "datetime", name = "create_time")
	public Date getCreate_time(){
		return create_time;
	}

	public void setCreate_time(Date create_time){
		this.create_time=create_time;
	}
	@Column(columnDefinition = "datetime", name = "update_time")
	public Date getUpdate_time(){
		return update_time;
	}

	public void setUpdate_time(Date update_time){
		this.update_time=update_time;
	}
	@Column(columnDefinition = "datetime", name = "pub_time")
	public Date getPub_time(){
		return pub_time;
	}

	public void setPub_time(Date pub_time){
		this.pub_time=pub_time;
	}
	@Column(columnDefinition = "varchar(200)", name = "pub_user")
	public String getPub_user(){
		return pub_user;
	}

	public void setPub_user(String pub_user){
		this.pub_user=pub_user;
	}
	@Column(columnDefinition = "varchar(200)", name = "create_user")
	public String getCreate_user(){
		return create_user;
	}

	public void setCreate_user(String create_user){
		this.create_user=create_user;
	}
	@Column(columnDefinition = "varchar(10)", name = "city_code")
	public String getCity_code(){
		return city_code;
	}

	public void setCity_code(String city_code){
		this.city_code=city_code;
	}
}

