package com.epam.springadv.model.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by Alexey on 18.10.2016.
 */
@MappedSuperclass
public class BaseDictionary {
    @Id
    @Column
    private Long id;

    @Column
    private String code;

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
}
