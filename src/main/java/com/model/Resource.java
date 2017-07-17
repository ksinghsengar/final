package com.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ResourceId")
    private Integer id;

    private String description;

    @ManyToOne
    private User createdBy;

    @ManyToOne
    private Topic topic;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date dateCreated;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date lastUpdated;

    @OneToOne
    private ResourceRating resourceRating;

    @OneToOne
    private ReadingItem readingItem;

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

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
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

    public ResourceRating getResourceRating() {
        return resourceRating;
    }

    public void setResourceRating(ResourceRating resourceRating) {
        this.resourceRating = resourceRating;
    }

    public ReadingItem getReadingItem() {
        return readingItem;
    }

    public void setReadingItem(ReadingItem readingItem) {
        this.readingItem = readingItem;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", createdBy=" + createdBy +
                ", topic=" + topic +
                ", dateCreated=" + dateCreated +
                ", lastUpdated=" + lastUpdated +
                ", resourceRating=" + resourceRating +
                ", readingItem=" + readingItem +
                '}';
    }
}
