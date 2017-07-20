package com.dao;

import com.model.Topic;
import com.model.User;

import java.util.Set;

/**
 * Created by krishan on 7/16/2017.
 */
public interface TopicDao {
    public boolean addTopic(Topic topic);
    public boolean deleteTopic(String name);
    public Set<Topic> findAllTopicOfUser(String userName);
    public boolean isTopicExistsForUser(User user, String topicName);
    public boolean changeVisibility(User user,String topicName,Topic.Visibility visibility);
    public Set<Topic> browseAllPublicTopic();

}
