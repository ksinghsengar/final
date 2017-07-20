package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class DefaultController {
    @RequestMapping("/")
    public ModelAndView display(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }



}
