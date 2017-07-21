package com.model;

import org.hibernate.annotations.CreationTimestamp;

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

    @ManyToOne(fetch = FetchType.LAZY)
    private  Topic topic;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Enumerated(EnumType.STRING)
    private Seriousness seriousness;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    Date dateCreated;

    public enum Seriousness{
        SERIOUS, VERY_SERIOUS, CASUAL;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Seriousness getSeriousness() {
        return seriousness;
    }

    public void setSeriousness(Seriousness seriousness) {
        this.seriousness = seriousness;
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
                ", topic=" + topic +
                ", user=" + user +
                ", seriousness=" + seriousness +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
