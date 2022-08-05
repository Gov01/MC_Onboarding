package com.onedirect.automation.MC.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="bot_subscription")
public class MCModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private Integer brand_id;

	private Integer has_bot_subscription;

	private Integer status;

	private Date created_at;

	private Date updated_at;

	public MCModel() {}

	public MCModel(Integer id, Integer brand_id, Integer has_bot_subscription, Integer status, Date created_at, Date updated_at) {
		this.id = id;
		this.brand_id = brand_id;
		this.has_bot_subscription = has_bot_subscription;
		this.status = status;
		this.created_at =created_at;
		this.updated_at = updated_at;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(Integer brand_id) {
		this.brand_id = brand_id;
	}

	public Integer getHas_bot_subscription() {
		return has_bot_subscription;
	}

	public void setHas_bot_subscription(Integer has_bot_subscription) {
		this.has_bot_subscription = has_bot_subscription;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
}
