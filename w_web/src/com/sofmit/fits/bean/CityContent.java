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
@Table(name = "city_content")
public class CityContent {
	//
	private String id;
	//
	private Integer type;
	//
	private String c_id;
	//
	private String m_id;
	//
	private String image;
	//
	private String content;
	//
	private Integer status;
	//
	private Integer sort;
	//
	private Date create_time;
	//
	private Date update_time;
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
	@Column(columnDefinition = "int", name = "type")
	public Integer getType(){
		return type;
	}

	public void setType(Integer type){
		this.type=type;
	}
	@Column(columnDefinition = "varchar(32)", name = "c_id")
	public String getC_id(){
		return c_id;
	}

	public void setC_id(String c_id){
		this.c_id=c_id;
	}
	@Column(columnDefinition = "varchar(32)", name = "m_id")
	public String getM_id(){
		return m_id;
	}

	public void setM_id(String m_id){
		this.m_id=m_id;
	}
	@Column(columnDefinition = "varchar(200)", name = "image")
	public String getImage(){
		return image;
	}

	public void setImage(String image){
		this.image=image;
	}
	@Column(columnDefinition = "text", name = "content")
	public String getContent(){
		return content;
	}

	public void setContent(String content){
		this.content=content;
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

