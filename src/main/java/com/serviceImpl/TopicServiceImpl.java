//package com.serviceImpl;
//
//
//import com.dao.TopicDao;
//import com.dao.UserDao;
//import com.model.Topic;
//import com.model.User;
//import com.service.TopicService;
//import com.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//
//@Service
//public class TopicServiceImpl implements TopicService {
//
//    @Autowired
//    TopicDao topicDao;
//
//    @Autowired
//    UserDao userDao;
//
//    @Autowired
//    UserService userService;
//
//    @Override
//    public boolean saveOrUpdateTopic(Topic topic, String userName) {
//        User user = userDao.getUserDetails(userName);
//        topic.getTopic_userList().add(user);
//        user.getUser_topicList().add(topic);
//        userService.saveOrUpdateUser(user);
//        topic.setDatecreated(new Date());
//        topic.setLastupdated(new Date());
//        topic.setVisibility(Topic.Visibility.PUBLIC);
//        return topicDao.saveTopicDetails(topic);
//    }
//
//    @Override
//    public Topic getTopicDetails(String topicName) {
//        return null;
//    }
//
//    @Override
//    public boolean deleteTopic(String topicName) {
//        return false;
//    }
//}
