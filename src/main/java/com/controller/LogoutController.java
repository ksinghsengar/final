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
    public ModelAndView logout( HttpServletRequest request,HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
            ModelAndView modelAndView = new ModelAndView("home");
            return modelAndView;
        }
        else{
            ModelAndView modelAndView = new ModelAndView("/");
            return modelAndView;
        }

    }
}
