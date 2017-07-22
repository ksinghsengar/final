package com.serviceImpl;

import com.dao.ResourceDao;
import com.model.LinkResource;
import com.model.Resource;
import com.model.User;
import com.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by krishan on 7/21/2017.
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    ResourceDao resourceDao;

    @Override
    public boolean addLink(User user, LinkResource linkResource, HttpServletRequest request)
    {
        linkResource.setCreatedBy(user);
        if(resourceDao.addResource(linkResource)){
            return  true;
        }
        else{
            return false;
        }
    }
}
