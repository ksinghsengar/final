package com.serviceImpl;


import com.dao.TopicDao;
import com.dao.UserDao;
import com.model.Topic;
import com.model.User;
import com.service.TopicService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Set;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicDao topicDao;

    @Autowired
    UserDao userDao;

    @Autowired
    UserService userService;

    @Override
    public boolean addTopic(User user, Topic topic) {
       System.out.println("In add Topic service");
        if(!topicDao.isTopicExistsForUser(user,topic.getName())) {
            System.out.println("Topic does not exists for user");
            System.out.println("topic in service"+ topic);
            topic.setCreatedBy(user);
            if (topicDao.addTopic(topic)) {
                System.out.println("in add topic service after adding topic");
                return true;
            }
            else{
                System.out.println("not succes in topic service");
              return false;
            }
        }
        else{
            System.out.println("topic name exists");
            return  false;
        }
    }


    @Override
    public boolean deleteTopic(String name) {
        if(topicDao.deleteTopic(name)) {
            return true;
        }
        else{
            return  false;
        }
    }

    @Override
    public Set<Topic> findAllTopicOfUser(String userName) {
         Set<Topic>  topicSet =  topicDao.findAllTopicOfUser(userName);
        return topicSet;
    }

    @Override
    public boolean isTopicExistsForUser(User user, String topicName) {
        if(topicDao.isTopicExistsForUser(user,topicName)) {
            return true;
        }
        else{
            return  false;
        }



    }

    @Override
    public boolean changeVisibility(User user, String topicName, Topic.Visibility visibility) {
        if(topicDao.changeVisibility(user,topicName,visibility)) {
            return true;
        }
        else{
            return  false;
        }
    }

    @Override
    public Set<Topic> browseAllPublicTopic() {
        Set<Topic>  topicSet =  topicDao.browseAllPublicTopic();
        return topicSet;
    }
}
