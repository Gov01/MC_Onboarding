package com.onedirect.automation.embeddedAnalytics.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="embeddedanalytics.brand_user_license_mapping")
public class brandUserLicenseMapModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer brand_id;

    private Integer brand_user_id;

    private String license_key;

    private Integer status;

    private Date created_at;

    private Date updated_at;

    private Date created_by;

    private Date updated_by;

    public brandUserLicenseMapModel() {
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

    public Integer getBrand_user_id() {
        return brand_user_id;
    }

    public void setBrand_user_id(Integer brand_user_id) {
        this.brand_user_id = brand_user_id;
    }

    public String getLicense_key() {
        return license_key;
    }

    public void setLicense_key(String license_key) {
        this.license_key = license_key;
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

    public Date getCreated_by() {
        return created_by;
    }

    public void setCreated_by(Date created_by) {
        this.created_by = created_by;
    }

    public Date getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(Date updated_by) {
        this.updated_by = updated_by;
    }

    public brandUserLicenseMapModel(Integer id, Integer brand_id, Integer brand_user_id, String license_key, Integer status, Date created_at, Date updated_at, Date created_by, Date updated_by) {
        this.id = id;
        this.brand_id = brand_id;
        this.brand_user_id = brand_user_id;
        this.license_key = license_key;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.created_by = created_by;
        this.updated_by = updated_by;
    }
}
