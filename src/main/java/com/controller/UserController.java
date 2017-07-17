package com.controller;

import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute("User") User user, BindingResult result) {
        ModelAndView modelAndView;
        if (result.hasErrors()) {
            System.out.println("BINDING Error");
        }
        if (userService.saveOrUpdateUser(user)) {
            modelAndView = new ModelAndView("dashboard");

        } else {
            modelAndView = new ModelAndView("home");

        }
        return modelAndView;

    }


    @RequestMapping(value = "/getuser/{name}")
    @ResponseBody
    public ModelAndView getUserDetails(@PathVariable("name")  String userName) {
        ModelAndView modelAndView = new ModelAndView("dashboard");
        System.out.println("users" + userService.getUserDetails(userName));
        modelAndView.addObject("Users", userService.getUserDetails(userName));
        return modelAndView;
    }

    @RequestMapping(value = "/login")
    public ModelAndView validateUser(@RequestParam("loginUser")String name, @RequestParam("loginPassword")String password) {
        ModelAndView modelAndView;

        if (userService.validateUser(name,password))
            modelAndView = new ModelAndView("dashboard");

        else {
            modelAndView = new ModelAndView("home");

        }
        return modelAndView;
    }

@RequestMapping(value = "/deleteuser/{name}")
@ResponseBody
public ModelAndView deleteUser(@PathVariable("name")  String userName) {
    ModelAndView modelAndView = new ModelAndView("dashboard");
    System.out.println("users" + userService.deleteUser(userName));
    modelAndView.addObject("Users", userService.deleteUser(userName));
    return modelAndView;
}


}