package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class controller {

        @RequestMapping("/index")
        public ModelAndView dispaly(){
            ModelAndView modelAndView = new ModelAndView("home");
            return modelAndView;
        }
    }


