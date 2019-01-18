package com.spring.mvcdemo.models;

import com.spring.mvcdemo.models.BaseEntity;
import com.vividsolutions.jts.geom.Geometry;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "layer")
public class LayerEntity extends BaseEntity implements Serializable {


    private static final long serialVersionUID = -7941769011539363185L;

    @Column(name = "name")
    private String name;

    @Column(columnDefinition="Geometry")
    //@Type(type = "org.hibernate.spatial.GeometryType")
    private Geometry geom;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Geometry getGeom() {
        return geom;
    }

    public void setGeom(Geometry geom) {
        this.geom = geom;
    }
}
