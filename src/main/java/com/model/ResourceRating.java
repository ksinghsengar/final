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
   private Resource resource;

   @OneToOne
   private User user;

    private Integer score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
                ", score=" + score +
                '}';
    }
}
