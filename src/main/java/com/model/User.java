package com.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "UserId")
    int id;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    @Lob
    @Column(columnDefinition = "mediumblob")
    private Byte[] photo;
    @Column(nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean admin;
    @Column(nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean active;
    private Date dateCreated;
    private Date lastUpdated;

    @ManyToMany(cascade = CascadeType.PERSIST)
    List<Topic> user_topicList = new ArrayList<Topic>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    List<Resource> user_resourceList = new ArrayList<Resource>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    List<ReadingItem> user_readingItemList  = new ArrayList<ReadingItem>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    List<ResourceRating> user_resourceRatingList = new ArrayList<ResourceRating>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    List<Subscription> user_subscriptionList = new ArrayList<Subscription>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(Byte[] photo) {
        this.photo = photo;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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

    public List<Topic> getUser_topicList() {
        return user_topicList;
    }

    public void setUser_topicList(List<Topic> user_topicList) {
        this.user_topicList = user_topicList;
    }

    public List<Resource> getUser_resourceList() {
        return user_resourceList;
    }

    public void setUser_resourceList(List<Resource> user_resourceList) {
        this.user_resourceList = user_resourceList;
    }

    public List<ReadingItem> getUser_readingItemList() {
        return user_readingItemList;
    }

    public void setUser_readingItemList(List<ReadingItem> user_readingItemList) {
        this.user_readingItemList = user_readingItemList;
    }

    public List<ResourceRating> getUser_resourceRatingList() {
        return user_resourceRatingList;
    }

    public void setUser_resourceRatingList(List<ResourceRating> user_resourceRatingList) {
        this.user_resourceRatingList = user_resourceRatingList;
    }

    public List<Subscription> getUser_subscriptionList() {
        return user_subscriptionList;
    }

    public void setUser_subscriptionList(List<Subscription> user_subscriptionList) {
        this.user_subscriptionList = user_subscriptionList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", photo=" + Arrays.toString(photo) +
                ", admin=" + admin +
                ", active=" + active +
                ", dateCreated=" + dateCreated +
                ", lastUpdated=" + lastUpdated +
                ", user_topicList=" + user_topicList +
                ", user_resourceList=" + user_resourceList +
                ", user_readingItemList=" + user_readingItemList +
                ", user_resourceRatingList=" + user_resourceRatingList +
                ", user_subscriptionList=" + user_subscriptionList +
                '}';
    }
}
