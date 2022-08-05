package com.onedirect.automation.chatview.model;

import javax.persistence.*;
@Entity
@Table(name="chatview_dumy")
public class chatviewModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public chatviewModel() {
    }
}