/*
package com.aspect;


import com.Util.SessionFactoryUtil;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Aspect
public class DaoAspect {

    Session session;
    @Before("within(com.daoImpl.*)")
    void getSession(){
        SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
        System.out.println("getSession in aspect");

    }

    @AfterReturning("within(com.daoImpl.*)")
    void closeSession(){
        session.getTransaction().commit();
        session.close();
        System.out.println("After Returning in aspect");
    }
}
*/
