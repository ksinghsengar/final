
package com.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.*;


@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TopicId")
    private int id;
    private String name;
    @ManyToOne
    private User createdBy;
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date datecreated;
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date lastupdated;
    @Enumerated(EnumType.STRING)
    private Visibility visibility;

    @OneToMany(mappedBy = "topic")
    private Set<Resource> topic_resourceList = new HashSet<>() ;

    @OneToMany(mappedBy = "topic")
    private Set<Subscription> topic_subscriptionList = new HashSet<>();


    public enum Visibility{
        PUBLIC,PRIVATE;
    }

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

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public Date getLastupdated() {
        return lastupdated;
    }

    public void setLastupdated(Date lastupdated) {
        this.lastupdated = lastupdated;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public Set<Resource> getTopic_resourceList() {
        return topic_resourceList;
    }

    public void setTopic_resourceList(Set<Resource> topic_resourceList) {
        this.topic_resourceList = topic_resourceList;
    }

    public Set<Subscription> getTopic_subscriptionList() {
        return topic_subscriptionList;
    }

    public void setTopic_subscriptionList(Set<Subscription> topic_subscriptionList) {
        this.topic_subscriptionList = topic_subscriptionList;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdBy=" + createdBy +
                ", datecreated=" + datecreated +
                ", lastupdated=" + lastupdated +
                ", visibility=" + visibility +
                ", topic_resourceList=" + topic_resourceList +
                ", topic_subscriptionList=" + topic_subscriptionList +
                '}';
    }
}
