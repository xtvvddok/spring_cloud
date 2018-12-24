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
@Table(name = "city_menu")
public class CityMenu {
	//
	private String image;
	//
	private String name;
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
	private String c_id;
	//
	private String city_code;
	//
	private String id;
	private String icon;
	private String icon_value;

	@Column(columnDefinition = "varchar(200)", name = "image")
	public String getImage(){
		return image;
	}

	public void setImage(String image){
		this.image=image;
	}
	@Column(columnDefinition = "varchar(200)", name = "name")
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name=name;
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
	@Column(columnDefinition = "varchar(32)", name = "c_id")
	public String getC_id(){
		return c_id;
	}

	public void setC_id(String c_id){
		this.c_id=c_id;
	}
	@Column(columnDefinition = "varchar(10)", name = "city_code")
	public String getCity_code(){
		return city_code;
	}

	public void setCity_code(String city_code){
		this.city_code=city_code;
	}
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
	@Column(columnDefinition = "varchar(255)", name = "icon")
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	@Column(columnDefinition = "varchar(100)", name = "icon_value")
	public String getIcon_value() {
		return icon_value;
	}

	public void setIcon_value(String icon_value) {
		this.icon_value = icon_value;
	}
	
	
}

