package com.model;

import org.hibernate.annotations.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@javax.persistence.Entity
public class EmailVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String verificationString;
    String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVerificationString() {
        return verificationString;
    }

    public void setVerificationString(String verificationString) {
        this.verificationString = verificationString;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "EmailVerification{" +
                "id=" + id +
                ", verificationString='" + verificationString + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
