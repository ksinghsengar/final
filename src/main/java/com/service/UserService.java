package com.service;


import com.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface  UserService {
    public boolean saveOrUpdateUser(User user,HttpServletRequest request, HttpServletResponse response);
    public User getUserDetails(String userName);
    public boolean deleteUser(String userName);
    public  boolean validateUser(String loginUser, String loginPassword, HttpServletRequest request);
    public boolean isEmailExists(String email);
    public boolean isUserNameExists(String userName);

}
