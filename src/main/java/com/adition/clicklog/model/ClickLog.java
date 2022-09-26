package com.adition.clicklog.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "click_log")
public class ClickLog implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private Long timestamp;

	private String type;

	private Long campaign;

	private Long banner;

	@Column(name = "content_unit")
	private Long contentUnit;

	private Long network;

	private Integer browser;

	@Column(name = "operating_system")
	private Integer operatingSystem;

	private Integer country;

	private Integer state;

	private Integer city;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getCampaign() {
		return campaign;
	}

	public void setCampaign(Long campaign) {
		this.campaign = campaign;
	}

	public Long getBanner() {
		return banner;
	}

	public void setBanner(Long banner) {
		this.banner = banner;
	}

	public Long getContentUnit() {
		return contentUnit;
	}

	public void setContentUnit(Long contentUnit) {
		this.contentUnit = contentUnit;
	}

	public Long getNetwork() {
		return network;
	}

	public void setNetwork(Long network) {
		this.network = network;
	}

	public Integer getBrowser() {
		return browser;
	}

	public void setBrowser(Integer browser) {
		this.browser = browser;
	}

	public Integer getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(Integer operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public Integer getCountry() {
		return country;
	}

	public void setCountry(Integer country) {
		this.country = country;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
