package com.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ResourceId")
    private Integer id;

    private String description;

    @ManyToMany(mappedBy = "user_resourceList")
    private List<User> resource_userList = new ArrayList<>();

    @ManyToOne
    private Topic topic;

    private Date dateCreated;

    private Date lastUpdated;

    @ManyToMany
    private List<ResourceRating> resource_resourceRatingList = new ArrayList<>();

    @ManyToMany
    private List<ReadingItem> resource_readingItemList = new ArrayList<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getResource_userList() {
        return resource_userList;
    }

    public void setResource_userList(List<User> resource_userList) {
        this.resource_userList = resource_userList;
    }

    public List<ResourceRating> getResource_resourceRatingList() {
        return resource_resourceRatingList;
    }

    public void setResource_resourceRatingList(List<ResourceRating> resource_resourceRatingList) {
        this.resource_resourceRatingList = resource_resourceRatingList;
    }

    public List<ReadingItem> getResource_readingItemList() {
        return resource_readingItemList;
    }

    public void setResource_readingItemList(List<ReadingItem> resource_readingItemList) {
        this.resource_readingItemList = resource_readingItemList;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", resource_userList=" + resource_userList +
                ", topic=" + topic +
                ", dateCreated=" + dateCreated +
                ", lastUpdated=" + lastUpdated +
                ", resource_resourceRatingList=" + resource_resourceRatingList +
                ", resource_readingItemList=" + resource_readingItemList +
                '}';
    }
}
