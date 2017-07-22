package com.controller;

import com.model.LinkResource;
import com.model.Resource;
import com.model.Topic;
import com.model.User;
import com.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by krishan on 7/21/2017.
 */
public class ResourceController {

    @Autowired
    ResourceService resourceService;

    @RequestMapping(value = "/addLink",method = RequestMethod.POST)
    public  @ResponseBody
    String addLink(@ModelAttribute LinkResource linkResource,
                    HttpServletRequest request){
        System.out.println( "In resource Controller");
        HttpSession httpSession =  request.getSession(false);
        User user  = (User)  httpSession.getAttribute("User");
        resourceService.addLink(user,linkResource,request);
        request.setAttribute("message","Link Added Successfully");
        return "Link added Successfully";

    }
}
