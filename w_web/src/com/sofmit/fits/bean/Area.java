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
@Table(name = "area")
public class Area {
	//
	private String id;
	//
	private String name;
	//
	private String parent;
	//
	private String level_type;
	//
	private String isleaf;
	//
	private String shortname;
	//
	private String status;
	//
	private String flag;
	//
	private Date createdate;
	//
	private Date updatedate;
	//
	private Integer searchnumber;
	//
	private String year;

	@Id
	@GenericGenerator(name = "sys_id", strategy = "uuid")
	@GeneratedValue(generator = "sys_id")
	@Column(columnDefinition = "varchar(50)", name = "ID", nullable = false)
	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id=id;
	}
	@Column(columnDefinition = "varchar(255)", name = "NAME")
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name=name;
	}
	@Column(columnDefinition = "varchar(255)", name = "PARENT")
	public String getParent(){
		return parent;
	}

	public void setParent(String parent){
		this.parent=parent;
	}
	@Column(columnDefinition = "varchar(255)", name = "LEVEL_TYPE")
	public String getLevel_type(){
		return level_type;
	}

	public void setLevel_type(String level_type){
		this.level_type=level_type;
	}
	@Column(columnDefinition = "varchar(255)", name = "ISLEAF")
	public String getIsleaf(){
		return isleaf;
	}

	public void setIsleaf(String isleaf){
		this.isleaf=isleaf;
	}
	@Column(columnDefinition = "varchar(255)", name = "SHORTNAME")
	public String getShortname(){
		return shortname;
	}

	public void setShortname(String shortname){
		this.shortname=shortname;
	}
	@Column(columnDefinition = "varchar(255)", name = "STATUS")
	public String getStatus(){
		return status;
	}

	public void setStatus(String status){
		this.status=status;
	}
	@Column(columnDefinition = "varchar(255)", name = "FLAG")
	public String getFlag(){
		return flag;
	}

	public void setFlag(String flag){
		this.flag=flag;
	}
	@Column(columnDefinition = "datetime", name = "CREATEDATE")
	public Date getCreatedate(){
		return createdate;
	}

	public void setCreatedate(Date createdate){
		this.createdate=createdate;
	}
	@Column(columnDefinition = "datetime", name = "UPDATEDATE")
	public Date getUpdatedate(){
		return updatedate;
	}

	public void setUpdatedate(Date updatedate){
		this.updatedate=updatedate;
	}
	@Column(columnDefinition = "int", name = "SEARCHNUMBER")
	public Integer getSearchnumber(){
		return searchnumber;
	}

	public void setSearchnumber(Integer searchnumber){
		this.searchnumber=searchnumber;
	}
	@Column(columnDefinition = "varchar(255)", name = "YEAR")
	public String getYear(){
		return year;
	}

	public void setYear(String year){
		this.year=year;
	}
}

