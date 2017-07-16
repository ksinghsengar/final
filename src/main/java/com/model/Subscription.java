package com.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SubscriptionId")
    private Integer id;

    @ManyToMany(mappedBy = "topic_subscriptionList")
    private  List<Topic> subscription_topicList = new ArrayList<>();

    @ManyToMany(mappedBy = "user_subscriptionList")
    private List<User> subscription_userList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Seriousness seriousness;

    Date dateCreated;

    public enum Seriousness{
        SERIOUS, VERY_SERIOUS, CASUAL;
    }

    public Seriousness getSeriousness() {
        return seriousness;
    }

    public void setSeriousness(Seriousness seriousness) {
        this.seriousness = seriousness;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Topic> getSubscription_topicList() {
        return subscription_topicList;
    }

    public void setSubscription_topicList(List<Topic> subscription_topicList) {
        this.subscription_topicList = subscription_topicList;
    }

    public List<User> getSubscription_userList() {
        return subscription_userList;
    }

    public void setSubscription_userList(List<User> subscription_userList) {
        this.subscription_userList = subscription_userList;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", subscription_topicList=" + subscription_topicList +
                ", subscription_userList=" + subscription_userList +
                ", seriousness=" + seriousness +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
