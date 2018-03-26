package com.daraghhiggins.shareprofile.Utils;

import com.daraghhiggins.shareprofile.User.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory session = buildSessionFactory();

    private static SessionFactory buildSessionFactory () {
        return new Configuration().configure().buildSessionFactory();
    }

    public static SessionFactory getSession() {
        return session;
    }

    public static void shutdown() {
        getSession().close();
    }

    public static void main(String[] args) {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        User user = new User();
        user.setUser_name("admin555");
        user.setFirstName("Daragh");
        user.setSurnName("Higgins");
        user.setPassword("password");
        user.setAccess_code(0);
        session.save(user);
        session.getTransaction().commit();
    }
}
