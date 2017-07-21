package com.controller;

import com.model.Topic;
import com.model.User;
import com.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Set;


@Controller
public class TopicController {

    @Autowired
    TopicService topicService;

    @RequestMapping(value = "/addTopic",method = RequestMethod.POST)
    public @ResponseBody
     String addTopic(@ModelAttribute Topic topic,
                                 HttpServletRequest request){
        HttpSession httpSession =  request.getSession(false);
        User user  = (User)  httpSession.getAttribute("User");

       if( topicService.addTopic(user,topic)){
           System.out.println("Topic Added successfully");
       }

      return "{}";

    }

    @RequestMapping("/deleteTopic")
    public ModelAndView deleteTopic(@RequestParam("topicName") String topicName,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        ModelAndView modelAndView;
        HttpSession httpSession = request.getSession(false);
        User user = (User) httpSession.getAttribute("User");
        if (topicService.isTopicExistsForUser(user, topicName)) {
            if (topicService.deleteTopic(topicName)) {
                httpSession.setAttribute("message", "Topic Deleted Successfully");
                modelAndView = new ModelAndView("dashboard");

            }
            else{
                httpSession.setAttribute("message", "Topic cannot be deleted");
                modelAndView = new ModelAndView("dashboard");
            }
        }
        else{
            httpSession.setAttribute("message", "Topic DoesNot Exists");
            modelAndView = new ModelAndView("dashboard");

        }
        return modelAndView;
    }

    @RequestMapping("/findAllTopicOfUser")
    public ModelAndView findAllTopicOfUser(HttpServletRequest request,
                                 HttpServletResponse response){
        HttpSession httpSession =  request.getSession(false);
        User user  = (User)  httpSession.getAttribute("User");
        Set<Topic> topicSet =   topicService.findAllTopicOfUser(user.getUserName());
        System.out.println("findAllTopicOfUser: "+topicSet);
        ModelAndView  modelAndView = new ModelAndView("dashboard");
        return modelAndView;

    }

    @RequestMapping("/changeVisibility")
    public ModelAndView changeVisibility(@RequestParam("topicName") String topicName ,@RequestParam Topic.Visibility visibility,HttpServletRequest  request,
                                           HttpServletResponse response){
        HttpSession httpSession =  request.getSession(false);
        User user  = (User)  httpSession.getAttribute("User");
        topicService.changeVisibility(user,topicName,visibility);
        ModelAndView  modelAndView = new ModelAndView("dashboard");
        return modelAndView;

    }



}
