package com.controller;

import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class DashboardController {
    @Autowired
    UserService userService;

    @RequestMapping("/getimage")
    public void getImage(@RequestParam("userName") String username, HttpServletResponse response)
    {
        User user = userService.getUserDetails(username);
        byte[] photo = user.getPhoto();
        try {
            response.getOutputStream().write(photo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
