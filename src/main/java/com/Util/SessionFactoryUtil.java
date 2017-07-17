package com.Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by krishan on 7/16/2017.
 */
@Component
public class SessionFactoryUtil {
     private static final SessionFactory sessionFactory;

        static {
            try {
                sessionFactory = new Configuration()
                        .configure()
                        .buildSessionFactory();

            } catch (Throwable ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }


        public static SessionFactory getSessionFactory() {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            return sessionFactory;
        }


    }


