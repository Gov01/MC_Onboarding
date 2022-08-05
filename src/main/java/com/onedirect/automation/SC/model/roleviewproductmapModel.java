package com.onedirect.automation.SC.model;
import javax.persistence.*;

@Entity
@Table(name="role_view_product_mapping")
public class roleviewproductmapModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="brand_id")
    private Integer brand_id;

    @Column(name="brand_user_id")
    private Integer brand_user_id;

    @Column(name="product_id")
    private Integer product_id;

    @Column(name="view_id")
    private Integer view_id;

    @Column(name="status")
    private Integer status;

    @Column(name="created_at")
    private String created_at;

    @Column(name="created_by")
    private Integer created_by;

    @Column(name="updated_at")
    private String updated_at;

    @Column(name="updated_by")
    private Integer updated_by;

    public roleviewproductmapModel(Integer id, Integer brand_id, Integer brand_user_id, Integer product_id, Integer view_id, Integer status, String created_at, Integer created_by, String updated_at, Integer updated_by) {
        this.id = id;
        this.brand_id = brand_id;
        this.brand_user_id = brand_user_id;
        this.product_id = product_id;
        this.view_id = view_id;
        this.status = status;
        this.created_at = created_at;
        this.created_by = created_by;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
    }

    public roleviewproductmapModel() {}


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

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getView_id() {
        return view_id;
    }

    public void setView_id(Integer view_id) {
        this.view_id = view_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public Integer getCreated_by() {
        return created_by;
    }

    public void setCreated_by(Integer created_by) {
        this.created_by = created_by;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public Integer getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(Integer updated_by) {
        this.updated_by = updated_by;
    }
}
