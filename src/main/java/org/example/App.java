package org.example;

import org.example.entity.User;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class App {
    public static void main( String[] args ) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        String hql = "FROM User";
        Query<User> query = session.createQuery(hql, User.class);
        List<User> users = query.list();
        session.getTransaction().commit();

        session.close();

    }
}
