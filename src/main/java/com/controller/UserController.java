package com.controller;

import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
public class UserController {

    @Autowired
    UserService userService;
    HttpServletRequest request;
    HttpSession session;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute("User") User user,
                                 @RequestParam("image") MultipartFile file,
                                 BindingResult result,
                                 HttpServletRequest request,
                                 HttpServletResponse response
    ) throws IOException, ServletException {

        if (!file.isEmpty()) {
            user.setPhoto(file.getBytes());
        }
        if (result.hasErrors()) {
            System.out.println("BINDING Error");
            response.sendRedirect("/index");
        }
        if (userService.saveOrUpdateUser(user, request, response)) {
            System.out.println("In user controller after save");
            HttpSession session = request.getSession();
            session.setAttribute("User",user);
           ModelAndView view = new ModelAndView("dashboard");
           return view;
        } else {
            ModelAndView modelAndView;
            modelAndView = new ModelAndView("home");
            return modelAndView;
        }
    }


    @RequestMapping(value = "/getuser/{name}")
    @ResponseBody
    public ModelAndView getUserDetails(@PathVariable("name") String userName, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("dashboard");
        System.out.println("users" + userService.getUserDetails(userName));
//        modelAndView.addObject("User", userService.getUserDetails(userName));
        return modelAndView;
    }

    @RequestMapping(value = "/login")
    public ModelAndView validateUser(@RequestParam("loginUser") String name,
                                     @RequestParam("loginPassword") String password,
                                     HttpServletRequest request)
            throws ServletException, IOException {

        System.out.println(" Controller started: ");
        if (userService.validateUser(name, password, request)) {
            System.out.println("get user details " + userService.getUserDetails(name));
            User user = userService.getUserDetails(name);
            System.out.println("User  in controller: " + user);
                session = request.getSession(true);
                session.setAttribute("User", user);
                System.out.println("Session created: ");

                ModelAndView modelAndView = new ModelAndView("dashboard");
                return modelAndView;

            }
            else {
                session.invalidate();
                ModelAndView modelAndView = new ModelAndView("home");
                return modelAndView;
            }
        }


    @RequestMapping(value = "/deleteuser/{name}")
    @ResponseBody
    public ModelAndView deleteUser(@PathVariable("name") String userName, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("dashboard");
        System.out.println("users" + userService.deleteUser(userName));
        modelAndView.addObject("Users", userService.deleteUser(userName));
        return modelAndView;
    }


}