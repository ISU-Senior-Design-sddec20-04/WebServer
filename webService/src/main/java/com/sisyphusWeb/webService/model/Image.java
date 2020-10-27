package com.sisyphusWeb.webService.model;

import java.nio.file.Path;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "images")
public class Image {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	
	private String fileName;
	
	private Path location;
	
	public Image() {
		
	}
	
	public Image(String fileName, Path location) {
		this.fileName = fileName;
		this.location = location;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Path getLocation() {
		return location;
	}

	public void setLocation(Path targetLocation) {
		this.location = targetLocation;
	}
}
