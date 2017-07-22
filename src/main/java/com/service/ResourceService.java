package com.service;

import com.model.LinkResource;
import com.model.Resource;
import com.model.Topic;
import com.model.User;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by krishan on 7/21/2017.
 */
public interface ResourceService {
    public boolean addLink(User user, LinkResource linkResource, HttpServletRequest request);
}
