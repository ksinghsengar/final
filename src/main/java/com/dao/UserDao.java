package com.dao;

import com.model.*;

import java.util.List;
import java.util.Map;


public interface UserDao {
    public  boolean saveOrUpdateUser(User user);
    public  User getUserDetails(String userName);
    public  boolean deleteUser(String userName);
    public  boolean validateUser(String loginUser, String loginPassword);
    public  Integer numberOfSubscription(String userName);
    public  List<Topic> getListOfTopicSubscribed(String userName);
    public  Integer numberOfTopicsCreated(String userName);
    public  List<Topic> getListOfTopicCreated(String userName);
    public  Integer numberOfResourcesCreated(String userName);
    public  List<Resource> getListOfResourceCreated(String userName);
    public  Integer numberOfReadItems(String userName);
    public  List<ReadingItem> getListOfReadItems(String userName);
    public  Integer numberOfResourcesRated(String userName);
    public  Map<Resource,ResourceRating> getListOfResourcesRated(String userName);



}
