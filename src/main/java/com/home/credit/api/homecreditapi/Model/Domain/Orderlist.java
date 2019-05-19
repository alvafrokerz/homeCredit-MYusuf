package com.home.credit.api.homecreditapi.Model.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity (name="orderlist")
@IdClass(Orderlist.class)
 public class Orderlist implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer  id;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "module_id",referencedColumnName = "id", updatable = false, insertable = false, nullable=false)
    @JsonManagedReference
    private Module module;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",referencedColumnName = "id", updatable = false, insertable = false, nullable=false)
    @JsonManagedReference
    private User user;



    public Integer  getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
