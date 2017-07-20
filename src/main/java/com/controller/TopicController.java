package com.controller;

import com.model.Topic;
import com.model.User;
import com.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Set;


@Controller
public class TopicController {

    @Autowired
    TopicService topicService;

    @RequestMapping("/addTopic")
    public ModelAndView addTopic(@ModelAttribute("Topic") Topic topic,
                                 HttpServletRequest request,
                                 HttpServletResponse response){
        HttpSession session =  request.getSession(false);
        User user  = (User)  session.getAttribute("User");
        if(topicService.isTopicExistsForUser(user,topic.getName())) {
            topic.setCreatedBy(user);
            topicService.addTopic(topic);
            session.setAttribute("message", "Topic Added Successfully");
            ModelAndView modelAndView = new ModelAndView("dashboard");
            return modelAndView;
        }
        else{
            session.setAttribute("message", "Topic Added UnSuccessfully");
            ModelAndView modelAndView = new ModelAndView("dashboard");
            return modelAndView;
        }

    }

    @RequestMapping("/deleteTopic")
    public ModelAndView deleteTopic(@RequestParam("topicName") String topicName,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        ModelAndView modelAndView;
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("User");
        if (topicService.isTopicExistsForUser(user, topicName)) {
            if (topicService.deleteTopic(topicName)) {
                session.setAttribute("message", "Topic Deleted Successfully");
                modelAndView = new ModelAndView("dashboard");

            }
            else{
                session.setAttribute("message", "Topic cannot be deleted");
                modelAndView = new ModelAndView("dashboard");
            }
        }
        else{
            session.setAttribute("message", "Topic DoesNot Exists");
            modelAndView = new ModelAndView("dashboard");

        }
        return modelAndView;
    }

    @RequestMapping("/findAllTopicOfUser")
    public ModelAndView findAllTopicOfUser(HttpServletRequest request,
                                 HttpServletResponse response){
        HttpSession session =  request.getSession(false);
        User user  = (User)  session.getAttribute("User");
        Set<Topic> topicSet =   topicService.findAllTopicOfUser(user.getUserName());
        System.out.println("findAllTopicOfUser: "+topicSet);
        ModelAndView  modelAndView = new ModelAndView("dashboard");
        return modelAndView;

    }

    @RequestMapping("/changeVisibility")
    public ModelAndView changeVisibility(@RequestParam("topicName") String topicName ,@RequestParam Topic.Visibility visibility,HttpServletRequest  request,
                                           HttpServletResponse response){
        HttpSession session =  request.getSession(false);
        User user  = (User)  session.getAttribute("User");
        topicService.changeVisibility(user,topicName,visibility);
        ModelAndView  modelAndView = new ModelAndView("dashboard");
        return modelAndView;

    }



}
