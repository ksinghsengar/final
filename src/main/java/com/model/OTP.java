package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OTP {

    @Id
    private Integer code;
    private String email;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "OTP{" +
                "code=" + code +
                ", email='" + email + '\'' +
                '}';
    }
}
