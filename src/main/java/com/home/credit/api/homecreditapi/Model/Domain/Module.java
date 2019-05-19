package com.home.credit.api.homecreditapi.Model.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity(name = "module")
public class Module {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
     private Integer id;

    @Column(name = "module_name")
    private String moduleName;

    @OneToMany(mappedBy = "module", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private Set<Orderlist> orderlist;

    public Integer  getId() {
        return id;
    }

    public void setId(Integer  id) {
        this.id = id;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Set<Orderlist> getOrderlist() {
        return orderlist;
    }

    public void setOrderlist(Set<Orderlist> orderlist) {
        this.orderlist = orderlist;
    }
}
