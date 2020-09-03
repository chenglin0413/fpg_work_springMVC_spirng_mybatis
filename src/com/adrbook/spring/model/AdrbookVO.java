package com.adrbook.spring.model;

import java.io.Serializable;

public class AdrbookVO implements Serializable {
	private String xuid;
	private String name;
	private String tel;
	private String gender;
	private String type;
	private Integer type_index;
	private String notes;
	private String timestamp;
	private String brow_ver;
	private String ip;
	public AdrbookVO(String xuid, String name, String tel, String gender, String type, Integer type_index, String notes,
			String timestamp,String ip,String brow_ver) {
		super();
		this.xuid = xuid;
		this.name = name;
		this.tel = tel;
		this.gender = gender;
		this.type = type;
		this.type_index = type_index;
		this.notes = notes;
		this.timestamp = timestamp;
		this.ip = timestamp;
		this.brow_ver = timestamp;
	}
	public String getXuid() {
		return xuid;
	}
	public void setXuid(String xuid) {
		this.xuid = xuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getType_index() {
		return type_index;
	}
	public void setType_index(Integer type_index) {
		this.type_index = type_index;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getBrow_ver() {
		return brow_ver;
	}
	public void setBrow_ver(String brow_ver) {
		this.brow_ver = brow_ver;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}

    public AdrbookVO(){
    	super();
    }
	@Override
	public String toString() {
		return "AdrbookVO [xuid=" + xuid + ", name=" + name + ", tel=" + tel + ", gender=" + gender + ", type=" + type
				+ ", type_index=" + type_index + ", notes=" + notes + ", timestamp=" + timestamp + ", brow_ver="
				+ brow_ver + ", ip=" + ip + "]";
	}

}
