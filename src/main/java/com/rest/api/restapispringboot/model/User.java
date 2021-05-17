package com.rest.api.restapispringboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    
    private int id;
    private String name;
    private String email;

    public User(){
    }

    public User(int id, String name, String email) {

        this.id = id;
        this.name = name;
        this.email = email;
        
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {

        return id;

    }

    public void setId(int id) {

        this.id = id;

    }

    public String getName() {

        return name;

    }

    public void setName(String name) {

        this.name = name;

    }

    public String getEmail() {

        return email;

    }

    public void setEmail(String email) {

        this.email = email;

    }

}
