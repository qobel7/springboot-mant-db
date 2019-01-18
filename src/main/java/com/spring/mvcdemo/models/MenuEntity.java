package com.spring.mvcdemo.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "menu")
public class MenuEntity extends BaseEntity implements Serializable {


    private static final long serialVersionUID = -7941769011539363185L;


    @Column(name = "name")
    @NotNull
    private String name;
    @Column(name = "url")
    @NotNull
    private String url;
    @Column(name = "parentID")
    @NotNull
    private long parentID;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "key",referencedColumnName = "name")
    private List<LanguageEntity> language;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getParentID() {
        return parentID;
    }

    public void setParentID(long parentID) {
        this.parentID = parentID;
    }

    public List<LanguageEntity>  getLanguage() {
        return language;
    }

    public void setLanguage(List<LanguageEntity>  language) {
        this.language = language;
    }
}
