package com.daoImpl;

import com.Util.SessionFactoryUtil;
import com.dao.UserDao;
import com.model.*;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao{

    SessionFactory sessionFactory;
    @Override
    public boolean saveOrUpdateUser(User user) {
        System.out.println("inside userDao Impl");
        System.out.println("SessionFactory ");
        System.out.println("Session ");
        sessionFactory = SessionFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        System.out.println("Session begin");
        System.out.println("firstname1:"+user.getFirstName());
        System.out.println("last1 "+user.getLastName());
        System.out.println("email1 "+user.getEmail());
        System.out.println("user1 "+user.getUserName());
        System.out.println("active:"+user.getActive());
        System.out.println("admin: "+user.getAdmin());
        session.save(user);
        System.out.println("saved ");
        session.getTransaction().commit();
        session.close();
        System.out.println("After session");
        return true;
    }

    @Override
    public User getUserDetails(String username) {
        SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
        Session session= sessionFactory.openSession();
        User user = new User();
        session.beginTransaction();
        String query = "from User where userName  = ?";
        Query query1 =  session.createQuery(query).setString(0,username);
        user  = (User) query1.uniqueResult();
        System.out.println("User Details: "+user);
//        Criteria criteria = session.createCriteria(User.class);
//        criteria.add(Restrictions.eq("userName",username));
//        user = (User)criteria.uniqueResult();
        session.getTransaction().commit();
        session.close();
        System.out.println("User in getUserDetails: "+user);
        return user;
    }

    @Override
    public boolean deleteUser(String username) {
        SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        String query = "DELETE from User where userName =?";
        Query query1 = session.createQuery(query).setString(0,username);
        query1.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("User is deleted: " );
        return true;

    }

    @Override
    public boolean validateUser(String loginUser, String loginPassword){
        sessionFactory = SessionFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String hql = "from User where (userName = ?  or email = ?) and password = ? ";
        Query query = session.createQuery(hql)
                .setString(0, loginUser)
                .setString(1, loginUser)
                .setString(2, loginPassword);
        return query.list().isEmpty();
    }

    @Override
    public Integer numberOfSubscription(String userName) {
        return null;
    }

    @Override
    public List<Topic> getListOfTopicSubscribed(String userName) {
        return null;
    }

    @Override
    public Integer numberOfTopicsCreated(String userName) {
        return null;
    }

    @Override
    public List<Topic> getListOfTopicCreated(String userName) {
        return null;
    }

    @Override
    public Integer numberOfResourcesCreated(String userName) {
        return null;
    }

    @Override
    public List<Resource> getListOfResourceCreated(String userName) {
        return null;
    }

    @Override
    public Integer numberOfReadItems(String userName) {
        return null;
    }

    @Override
    public List<ReadingItem> getListOfReadItems(String userName) {
        return null;
    }

    @Override
    public Integer numberOfResourcesRated(String userName) {
        return null;
    }

    @Override
    public Map<Resource, ResourceRating> getListOfResourcesRated(String userName) {
        return null;
    }
}
