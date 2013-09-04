package org.jas.downloader.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jas.downloader.bean.Installer;

@Entity
@Table(name = "counter")
public class Counter {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private String remoteAddress;
	private Long timestamp;
	private Installer type;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getRemoteAddress() {
		return remoteAddress;
	}
	
	public void setRemoteAddress(String remoteAddress) {
		this.remoteAddress = remoteAddress;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	
	public Installer getType() {
		return type;
	}

	public void setType(Installer type) {
		this.type = type;
	}

}
