package com.service;


import com.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface  UserService {
    public boolean saveOrUpdateUser(User user);
    public User getUserDetails(String userName);
    public boolean deleteUser(String userName);
    public  boolean validateUser(String loginUser, String loginPassword, HttpServletRequest request);

}
