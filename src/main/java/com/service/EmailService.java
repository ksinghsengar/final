package com.service;

public interface EmailService {
  public String randomAlphaNumeric(int count);
  public boolean sendMail(String email);
  public boolean saveVerificationString(String str, String email);
}
