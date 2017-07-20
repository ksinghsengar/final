package com.daoImpl;

import com.Util.SessionFactoryUtil;
import com.dao.EmailVerificationDao;
import com.model.EmailVerification;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class EmailVerificationDaoImpl implements EmailVerificationDao {

    SessionFactory sessionFactory;
    @Override
    public boolean saveVerificationString(EmailVerification emailVerification) {
        System.out.println("In email verificaion dao");
        sessionFactory = SessionFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        System.out.println("email verification object;"+emailVerification);
        session.save(emailVerification);
        session.getTransaction().commit();
        session.close();
        return true;
    }
}
