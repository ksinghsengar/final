package com.serviceImpl;

import com.dao.UserDao;
import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;



    public boolean saveOrUpdateUser(User user, HttpServletRequest request, HttpServletResponse response) {
        user.setAdmin(false);
        user.setActive(true);
        if (!userDao.isEmailExists(user.getEmail())) {
            System.out.println("if Email exists");

            if (!userDao.isUserNameExists(user.getUserName())) {
                System.out.println("If user name exists");

                if (userDao.saveOrUpdateUser(user)) {
                    System.out.println("if user saved");
                    return true;
                }
                else {
                    request.setAttribute("regError", "Registration is Unsuccessful");
                    return false;
                }
            }
            else {
                request.setAttribute("regError","Username is Already Taken" );
                return false;
            }

        }
        else{
            request.setAttribute("regError", "You are Already Registered");
            return false;
        }
    }

    public User getUserDetails( String userName) {
        System.out.println("In get user Details");
         User user = userDao.getUserDetails(userName);
        System.out.println("User "+user);
        return user;
    }

    public boolean deleteUser(String userName) {
        return userDao.deleteUser(userName);
    }

    public boolean validateUser(String loginUser, String loginPassword, HttpServletRequest request) {
        System.out.println(" in validated user sevice ");
            if (userDao.validateUser(loginUser, loginPassword)) {
                User user = userDao.getUserDetails(loginUser);
                if (user != null) {

                    HttpSession session = request.getSession();
                    session.setAttribute("User",user);
                    System.out.println(" validated " + userDao.validateUser(loginUser, loginPassword));
                    return true;

                }
                else{
                    request.setAttribute("error","Something Unexpected Occur");
                    return false;
                }
            }
            else {
                HttpSession session = request.getSession(false);
                session.invalidate();
                request.setAttribute("error", "Username or Password is Incorrect");
                return false;
            }
    }



    @Override
    public boolean isEmailExists(String email) {
        if(userDao.isEmailExists(email))
        return  true;
        else
            return false;
    }

    @Override
    public boolean isUserNameExists(String userName) {
        if(userDao.isUserNameExists(userName))
            return  true;
        else
            return false;
    }
}
