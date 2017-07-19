package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
public class LogoutController {


    @RequestMapping("/logout")
    public void logout( HttpServletRequest request,HttpServletResponse response) throws IOException {
        ModelAndView modelAndView =null;
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
            response.getWriter().write("You have successfully Logged out!!");
            response.sendRedirect("/index");

        }
        else{
            response.sendRedirect("/");
        }

    }
}
