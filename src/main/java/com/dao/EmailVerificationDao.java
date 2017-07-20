package com.dao;


import com.model.EmailVerification;

public interface EmailVerificationDao {
    public boolean saveVerificationString(EmailVerification emailVerification);
}
