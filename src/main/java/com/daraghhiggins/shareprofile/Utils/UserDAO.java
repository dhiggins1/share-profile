package com.daraghhiggins.shareprofile.Utils;


import com.daraghhiggins.shareprofile.User.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class UserDAO {
    private static UserDAO instance;

    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    private ServiceRegistry serviceRegistry;
    private SessionFactory sessionFactory;

    private UserDAO() {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        config.addAnnotatedClass(User.class);
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        sessionFactory = config.buildSessionFactory(serviceRegistry);
    }

    public Optional<User> getUserByUsername(final String username) {
        Optional<User> userOptional = Optional.empty();
        Optional<List<User>> userList = this.getUsers();
        if(userList.isPresent()) {
            for(User user : userList.get()) {
                if (user.getUser_name().equals(username)) {
                    userOptional = Optional.of(user);
                    return userOptional;
                }
            }
        }
        return userOptional;
    }

    public Optional<List<User>> getUsers() {
        Optional userList = Optional.empty();
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            CriteriaQuery<User> criteriaQuery = session.getCriteriaBuilder().createQuery(User.class);
            criteriaQuery.from(User.class);
            userList = Optional.of(session.createQuery(criteriaQuery).getResultList());
            tx.commit();
            session.close();

        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void deleteUser(String username, String usernameToDelete ) {
        Optional<User> user = this.getUserByUsername(username);
        final int accessCode = user.get().getAccess_code();

        if (accessCode == 0) {
            try (Session session = sessionFactory.openSession()) {
                Optional<User> userToDelete = this.getUserByUsername(usernameToDelete);
                Transaction tx = session.beginTransaction();
                Object id = userToDelete.get();
                session.delete(id);
                tx.commit();
                session.close();
            } catch (HibernateException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("Do not have rights to delete");
        }
    }

    public void createUser(String username, String password,
                           String firstName, String surnName) {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();

        User user = new User();
        user.setUser_name(username);
        user.setFirstName(firstName);
        user.setSurnName(surnName);

        UserUtility userUtility = new UserUtility();
        String hashedPw = userUtility.hash(password);
        user.setPassword(hashedPw);

        user.setAccess_code(1);
        session.save(user);
        session.getTransaction().commit();
    }

    public static void main (String[] args) {
        UserDAO userDAO = new UserDAO();
//        userDAO.createUser("liam", "password", "Liam", "Miam");
//        userDAO.deleteUser("admin555", "admin123");
        userDAO.getUserByUsername("liam");
    }
}
