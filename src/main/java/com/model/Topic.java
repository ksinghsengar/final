
package com.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TopicId")
    private int id;
    private String name;
    private Date datecreated;
    private Date lastupdated;
    @Enumerated(EnumType.STRING)
    private Visibility visibility;

    @ManyToMany(mappedBy = "user_topicList")
    List <User> topic_userList = new ArrayList<>();

    @OneToMany
    private List<Resource> topic_resourceList = new ArrayList<Resource>() ;

    @OneToMany
    private List<Subscription> topic_subscriptionList = new ArrayList<Subscription>();


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

    public List<User> getTopic_userList() {
        return topic_userList;
    }

    public void setTopic_userList(List<User> topic_userList) {
        this.topic_userList = topic_userList;
    }

    public List<Resource> getTopic_resourceList() {
        return topic_resourceList;
    }

    public void setTopic_resourceList(List<Resource> topic_resourceList) {
        this.topic_resourceList = topic_resourceList;
    }

    public List<Subscription> getTopic_subscriptionList() {
        return topic_subscriptionList;
    }

    public void setTopic_subscriptionList(List<Subscription> topic_subscriptionList) {
        this.topic_subscriptionList = topic_subscriptionList;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", datecreated=" + datecreated +
                ", lastupdated=" + lastupdated +
                ", visibility=" + visibility +
                ", topic_userList=" + topic_userList +
                ", topic_resourceList=" + topic_resourceList +
                ", topic_subscriptionList=" + topic_subscriptionList +
                '}';
    }
}
