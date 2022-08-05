package com.onedirect.automation.onedirect.model;

import javax.persistence.*;
@Entity
@Table(name="od_dumy")
public class onedirectModel {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public onedirectModel() {
    }
}
