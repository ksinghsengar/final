package com.controller;

import com.service.EmailService;
import com.service.UserService;
import com.serviceImpl.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ForgotPasswordController {

    @Autowired
    UserService userService;
    @Autowired


   EmailService emailService;
    @RequestMapping("/forgotPassword")
    public ModelAndView forgotPassword(){
        ModelAndView modelAndView = new ModelAndView("emailVerification");
        return modelAndView;
    }

    @RequestMapping("/verifyEmail")
    public ModelAndView sendMail(@RequestParam("email") String email){
        System.out.println("email in varifyemail"+ email);
        if(userService.isEmailExists(email)){
            System.out.println("email exists: "+userService.isEmailExists(email));
            String str = emailService.randomAlphaNumeric(30);
            System.out.println("randomString "+str);
            emailService.saveVerificationString(str,email);
            System.out.println("after verification string"+emailService.saveVerificationString(str,email));
//            emailService.sendMail(email);
            ModelAndView modelAndView   = new ModelAndView("home");
            return modelAndView;

        }
        else{
            ModelAndView modelAndView  = new ModelAndView("home");
            return modelAndView;
        }


    }





}
