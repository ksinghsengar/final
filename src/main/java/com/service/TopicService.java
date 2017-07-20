package com.service;

import com.model.Topic;
import com.model.User;

import java.util.Set;

public interface TopicService {

    public boolean addTopic(Topic topic);
    public boolean deleteTopic(String name);
    public Set<Topic> findAllTopicOfUser(String userName);
    public boolean isTopicExistsForUser(User user, String topicName);
    public boolean changeVisibility(User user,String topicName,Topic.Visibility visibility);
    public Set<Topic> browseAllPublicTopic();
}
