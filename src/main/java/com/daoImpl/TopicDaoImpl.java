package com.daoImpl;

import com.Util.SessionFactoryUtil;
import com.dao.TopicDao;
import com.model.Topic;
import com.model.User;
import com.service.TopicService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpSession;
import java.util.Set;

/**
 * Created by krishan on 7/16/2017.
 */

@Repository
public class TopicDaoImpl implements TopicDao{

    SessionFactory sessionFactory;

    @Override
    public boolean addTopic(Topic topic) {
        System.out.println("In addTopic dao");
        sessionFactory = SessionFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(topic);
        System.out.println("saved ");
        session.getTransaction().commit();
        session.close();
        System.out.println("After session");
        return true;
    }

    public boolean deleteTopic(String name) {
        sessionFactory = SessionFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String query  = "delete from Topic where name = ?";
        Query query1 = session.createQuery(query).setString(0,name);
        query1.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("After session");
        return true;
    }

    public Set<Topic> findAllTopicOfUser(String userName) {
        sessionFactory = SessionFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String query  = "select topicSet from User where userName = ?";
        Query query1 = session.createQuery(query).setString(0,userName);
        Set<Topic> topicSet  = (Set<Topic>) query1.list();
        session.getTransaction().commit();
        session.close();
        System.out.println("After session");
        return topicSet;
    }

    public boolean isTopicExistsForUser(User user,String topicName) {
        boolean empty;
        System.out.println("In topic Da0 exists for user");
        sessionFactory = SessionFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String query  = "select name from Topic where createdBy = ? and name=?";
        Query query1 = session.createQuery(query)
                .setInteger(0,user.getId())
                .setString(1,topicName);
        empty = query1.list().isEmpty();
        session.getTransaction().commit();
        session.close();
        System.out.println("After session");
        if(empty){
        return false;
        }
        else{
            return true;
        }

    }

    public boolean changeVisibility(User user,String topicName,Topic.Visibility visibility) {
        boolean empty;
        sessionFactory = SessionFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String query  = "update Topic  set visibility = ? where name = ? and createdBy =?";
        Query query1 = session.createQuery(query)
                .setParameter(0,visibility)
                .setString(1,topicName)
                .setInteger(2,user.getId());
        query1.executeUpdate();
        System.out.println("After changing visibility");
        session.getTransaction().commit();
        session.close();
        System.out.println("After session");
        return true;
    }

    public Set<Topic> browseAllPublicTopic() {
        sessionFactory = SessionFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String query  = "from Topic where visibility= Visibility.PUBLIC";
        Query query1 = session.createQuery(query);
        Set<Topic> topicSet = (Set<Topic>)query1.list();
        session.getTransaction().commit();
        session.close();
        System.out.println("After session");
        return topicSet;
    }




}
