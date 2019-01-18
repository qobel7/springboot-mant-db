package com.spring.mvcdemo.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "language")
public class LanguageEntity extends BaseEntity {

    private static final long serialVersionUID = -7941769011539363185L;


    @Column(name = "key" ,length = 255)
    @NotNull
    private String key;

    @Column(name = "value" ,length = 255,unique = true)
    @NotNull
    private String value;

    @Column(name = "type",length = 10)
    @NotNull
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    private MenuEntity menu;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MenuEntity getMenu() {
        return menu;
    }

    public void setMenu(MenuEntity menu) {
        this.menu = menu;
    }
}
