package com.serviceImpl;

import com.dao.UserDao;
import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    public boolean saveOrUpdateUser(User user) {

        user.setDateCreated(new Date());
        user.setLastUpdated(new Date());
        user.setAdmin(false);
        user.setActive(true);

        return userDao.saveOrUpdateUser(user);
    }

    public User getUserDetails( String userName) {
        return userDao.getUserDetails(userName);
    }

    public boolean deleteUser(String userName) {
        return userDao.deleteUser(userName);
    }

    public boolean validateUser(String loginUser, String loginPassword){
        if(userDao.validateUser(loginUser,loginPassword)){

            return false;
        }
        return true;
    }

}
