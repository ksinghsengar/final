package com.controller;

import com.service.EmailService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ForgotPasswordController {

    @Autowired
    UserService userService;

    EmailService emailService;

    @RequestMapping("/forgotPassword")
    public ModelAndView forgotPassword(){
        ModelAndView modelAndView = new ModelAndView("emailVerification");
        return modelAndView;
    }

   /* @RequestMapping("/verifyEmail")
    public ModelAndView verifyEmail(@RequestParam("email") String email){
        if(userService.verifyEmail(email))


    }*/
}
