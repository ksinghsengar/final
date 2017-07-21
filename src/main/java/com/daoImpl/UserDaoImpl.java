package com.daoImpl;

import com.Util.SessionFactoryUtil;
import com.dao.UserDao;
import com.model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;



@Repository
public class UserDaoImpl implements UserDao{

    @Override
    public boolean saveOrUpdateUser(User user) {
        System.out.println("inside userDao Impl");
        System.out.println("SessionFactory ");
        System.out.println("Session ");
        SessionFactory  sessionFactory = SessionFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        System.out.println("Session begin");
        System.out.println("firstname1:"+user.getFirstName());
        System.out.println("last1 "+user.getLastName());
        System.out.println("email1 "+user.getEmail());
        System.out.println("user1 "+user.getUserName());
        System.out.println("active:"+user.getActive());
        System.out.println("admin: "+user.getAdmin());
        System.out.println("Save User: "+session.save(user));
        System.out.println("saved ");
        session.getTransaction().commit();
        session.close();
        System.out.println("After session");
        return true;
    }

    @Override
    public User getUserDetails(String username) {
        System.out.println("In get User Details Dao");
        SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
        Session session= sessionFactory.openSession();
        User user;
        System.out.println("after User");
        session.beginTransaction();
        String query = "from User where userName  = ? or email = ?";
        Query query1 =  session.createQuery(query)
                .setString(0,username)
                .setString(1,username);
        System.out.println("query"+ query1.getQueryString());
        System.out.println("query1.uniqueResult()"+query1.list());
        user = (User) query1.uniqueResult();
        System.out.println("user in dao: "+user);
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
         SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String hql = "from User where (userName = ?  or email = ?) and password = ? ";
        Query query = session.createQuery(hql)
                .setString(0, loginUser)
                .setString(1, loginUser)
                .setString(2, loginPassword);
        System.out.println();
         boolean empty = query.list().isEmpty();
         if(!empty){
             System.out.println(" not of empty "+!empty);
             session.getTransaction().commit();
             session.close();
             return true;
         }
         else {
             System.out.println("loginUser " + loginUser + " loginPassword: " + loginPassword);
             System.out.println("empty  " + empty);
             session.getTransaction().commit();
             session.close();
             return false;
         }

    }

    @Override
    public boolean isEmailExists(String email) {
        System.out.println("In is email exists dao"+ email);
        boolean empty;
        SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        String query = "from User where email = ?";
        Query query1 =  session.createQuery(query)
                .setString(0,email);
        empty = query1.list().isEmpty();
        System.out.println("is email exists "+empty);
        session.getTransaction().commit();
        session.close();
        if(empty) {
            System.out.println("no similar email");
            return false;
        }        else {
            System.out.println("similar email exists");
            return true;
        }
    }

    public boolean isUserNameExists(String userName) {
        boolean empty;
        SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        String query = "from User where userName = ?";
        Query query1 =  session.createQuery(query)
                .setString(0,userName);
        empty = query1.list().isEmpty();
        session.getTransaction().commit();
        session.close();
        if(empty)
            return false;
        else
            return true;
    }
}
