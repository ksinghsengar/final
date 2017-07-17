package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {
    @RequestMapping("/index")
    public ModelAndView display() {
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }
}
