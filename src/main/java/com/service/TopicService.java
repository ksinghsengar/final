package com.service;

import com.model.Topic;
import com.model.User;

/**
 * Created by krishan on 7/17/2017.
 */

public interface TopicService {
    public boolean saveOrUpdateTopic(Topic topic);
    public Topic getTopicDetails(String topicName);
    public boolean deleteTopic(String topicName);
}
