package com.model;

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
    @ManyToMany(mappedBy = "resource_readingItemList")
    private List<Resource> readingItem_resourceList = new ArrayList<>();
    @ManyToMany(mappedBy = "user_readingItemList")
    List<User> readingItem_userList = new ArrayList<>();
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private  Boolean isRead;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Resource> getReadingItem_resourceList() {
        return readingItem_resourceList;
    }

    public void setReadingItem_resourceList(List<Resource> readingItem_resourceList) {
        this.readingItem_resourceList = readingItem_resourceList;
    }

    public List<User> getReadingItem_userList() {
        return readingItem_userList;
    }

    public void setReadingItem_userList(List<User> readingItem_userList) {
        this.readingItem_userList = readingItem_userList;
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
                ", readingItem_resourceList=" + readingItem_resourceList +
                ", readingItem_userList=" + readingItem_userList +
                ", isRead=" + isRead +
                '}';
    }
}
