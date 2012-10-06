package com.umitunal.model;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: umitunal
 */
@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "COUNTRY_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "COUNTRY_CODE")
    private String code;

    @Column(name = "COUNTRY_NAME")
    private String name;

    public Country() {
    }

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
