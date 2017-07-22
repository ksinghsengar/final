package com.daoImpl;

import com.Util.SessionFactoryUtil;
import com.dao.ResourceDao;
import com.model.LinkResource;
import com.model.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


/**
 * Created by krishan on 7/16/2017.
 */
@Repository
public class ResourceDaoImpl implements ResourceDao {

    SessionFactory sessionFactory;
    @Override
    public boolean addResource(LinkResource linkResource) {
        sessionFactory = SessionFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(linkResource);
        System.out.println("saved ");
        session.getTransaction().commit();
        session.close();
        System.out.println("After session");
        return true;
    }
}
