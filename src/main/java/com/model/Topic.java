
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
    @ManyToOne(fetch = FetchType.LAZY)
    private User createdBy;
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date datecreated;
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date lastupdated;
    @Enumerated(EnumType.STRING)
    private Visibility visibility;

   /* @OneToMany(mappedBy = "topic")
    private Set<Resource> resourceList = new HashSet<>() ;

    @OneToMany(mappedBy = "topic")
    private Set<Subscription> subscriptionList = new HashSet<>();
*/
    public Topic() {
    }



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

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdBy=" + createdBy +
                ", datecreated=" + datecreated +
                ", lastupdated=" + lastupdated +
                ", visibility=" + visibility +
                '}';
    }
}
