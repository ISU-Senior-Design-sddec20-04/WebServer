package com.sisyphusWeb.webService.model.table;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Table implements ConnectResponse{

	@Id
	private String id;
	
	private String type;
	
	private String pi_id;
	
	private String name;
	
	private String firmware_version;
	
	private String software_version;
	
	public Table() {
		
	}

	public Table(String id, String type, String pi_id, String name, String firmware_version,
			String software_version) {
		this.id = id;
		this.type = type;
		this.pi_id = pi_id;
		this.name = name;
		this.firmware_version = firmware_version;
		this.software_version = software_version;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPi_id() {
		return pi_id;
	}

	public void setPi_id(String pi_id) {
		this.pi_id = pi_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirmware_version() {
		return firmware_version;
	}

	public void setFirmware_version(String firmware_version) {
		this.firmware_version = firmware_version;
	}

	public String getSoftware_version() {
		return software_version;
	}

	public void setSoftware_version(String software_version) {
		this.software_version = software_version;
	}
	
	
}
