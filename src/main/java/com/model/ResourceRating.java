package com.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ResourceRating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ResourceRatingId")
    private Integer id;

    @ManyToMany(mappedBy = "resource_resourceRatingList")
    List <Resource> resourceRating_resourceList = new ArrayList<>();

    @ManyToMany(mappedBy = "user_resourceRatingList")
    List<User> resourceRating_userList = new ArrayList<>();

    private Integer score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Resource> getResourceRating_resourceList() {
        return resourceRating_resourceList;
    }

    public void setResourceRating_resourceList(List<Resource> resourceRating_resourceList) {
        this.resourceRating_resourceList = resourceRating_resourceList;
    }

    public List<User> getResourceRating_userList() {
        return resourceRating_userList;
    }

    public void setResourceRating_userList(List<User> resourceRating_userList) {
        this.resourceRating_userList = resourceRating_userList;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "ResourceRating{" +
                "id=" + id +
                ", resourceRating_resourceList=" + resourceRating_resourceList +
                ", resourceRating_userList=" + resourceRating_userList +
                ", score=" + score +
                '}';
    }
}
