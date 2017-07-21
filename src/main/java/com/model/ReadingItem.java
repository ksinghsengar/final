package com.model;

import com.sun.org.apache.regexp.internal.RE;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ReadingItem{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ReadingItemId")
    private Integer id;

    @OneToOne
    private User user;

    @OneToOne
    private Resource resource;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    private  Boolean isRead;

    public Integer getId() {
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

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    @Override
    public String toString() {
        return "ReadingItem{" +
                "id=" + id +
                ", isRead=" + isRead +
                '}';
    }
}
