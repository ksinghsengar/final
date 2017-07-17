package com.service;


import com.model.User;

import java.util.List;

public interface  UserService {
    public boolean saveOrUpdateUser(User user);
    public User getUserDetails(String userName);
    public boolean deleteUser(String userName);
    public  boolean validateUser(String loginUser,String loginPassword);

}
