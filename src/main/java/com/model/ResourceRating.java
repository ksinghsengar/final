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

   @OneToOne
   private User user;

   @OneToOne
   private Resource resource;

    private Integer score;

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
                ", user=" + user +
                ", resource=" + resource +
                ", score=" + score +
                '}';
    }
}
