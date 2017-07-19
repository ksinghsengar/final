package com.service;

import com.model.Topic;
import com.model.User;

public interface TopicService {
    public boolean saveOrUpdateTopic(Topic topic);
    public Topic getTopicDetails(String topicName);
    public boolean deleteTopic(String topicName);
}
