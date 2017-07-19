package com.serviceImpl;

import com.Util.HttpSessionUtil;
import com.dao.UserDao;
import com.model.User;
import com.service.UserService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    HttpServletRequest request;
    public boolean saveOrUpdateUser(User user) {
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

    public boolean validateUser(String loginUser, String loginPassword, HttpServletRequest request) {
        System.out.println(" in validated user sevice ");
            if (userDao.validateUser(loginUser, loginPassword)) {
                System.out.println(" validated " + userDao.validateUser(loginUser, loginPassword));
                return true;

            }

        else {
            return false;
        }
    }
}
