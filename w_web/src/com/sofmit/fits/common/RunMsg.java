package com.sofmit.fits.common;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

public class RunMsg {
	
	//�Ƿ��쳣
	private boolean state;
	//����
	private String msg;
	
	private Map<String,Object> info;
	
	private JSONObject json;
	

	
	public void put(String name,Object object){
		if(isNull()){
//			this.json.getJSONArray("result").add(new HashMap<>().put(name, object));
			this.json.getJSONObject("result").accumulate(name, object);
		} else {
			this.json.accumulate("result", new Object());
		}
		
	}
//	public setJson(Object object){
//		this.json.getJSONArray("result").
//		this.json.getJSONArray("result").add(object);
		
//	}
	
	public RunMsg() {
		this.state = false;
	}

	public RunMsg(boolean state, String msg) {
		this.state = state;
		this.msg = msg;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getInfo() {
		return info;
	}

	public void setInfo(Map<String, Object> info) {
		this.info = info;
	}

	public JSONObject getJson() {
		return json;
	}

	public void setJson(JSONObject json) {
		this.json = json;
	}
	
	
	public boolean isNull(){
		if(this.json == null){
			return false;
		} else if(!"1".equals(this.json.get("status").toString())){
			return false;
		} else if(this.json.get("result") != null){
			return true;
		}
		return false;
	}
	
}
