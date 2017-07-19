package com.service;

import org.springframework.stereotype.Service;


public interface EmailService {
    public boolean sendMail(String email);
}
