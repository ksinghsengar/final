package com.dao;

import com.model.*;

import java.util.List;
import java.util.Map;


public interface UserDao {
    public  boolean saveOrUpdateUser(User user);
    public  User getUserDetails(String userName);
    public  boolean deleteUser(String userName);
    public  boolean validateUser(String loginUser, String loginPassword);
    public boolean isEmailExists(String email);
    public boolean isUserNameExists(String userName);



}
