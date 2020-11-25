package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    Util util = new Util();

    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {

        Session session = util.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("create table if not exists user(" +
                    "id bigint auto_increment primary key," +
                    "name varchar(45) not null," +
                    "lastname varchar(45) not null," +
                    "age tinyint not null);");

            query.executeUpdate();
            t.commit();
            session.close();
        } catch (Exception e) {

        }

    }


    @Override
    public void dropUsersTable() {
        Session session = util.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("DROP TABLE  user;");
            query.executeUpdate();
            t.commit();
            session.close();
        } catch (Exception e) {

        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User users = new User();
        Util util = new Util();
        Session session = util.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            users.setName(name);
            users.setLastName(lastName);
            users.setAge(age);

            session.save(users);
            t.commit();
            util.shutdown();
            System.out.format(" User с именем – %s добавлен в базу данных \n", name);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        Session session = util.getSessionFactory().openSession();
        User users = new User();
        Transaction t = session.beginTransaction();
        try {
            users.setId(id);

            session.remove(users);
            t.commit();
            util.shutdown();
        } catch (Exception e) {

        }

    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String users = "select * from user";
        Session session = util.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();

        try {
            userList = session.createSQLQuery(users).addEntity(User.class).list();

            for (User user : userList) {
                System.out.println(user);
            }
            t.commit();
            session.close();
            return userList;

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void cleanUsersTable() {
        Session session = util.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("TRUNCATE TABLE  user;");
            query.executeUpdate();
            t.commit();
            session.close();
        } catch (Exception e) {

        }
    }
}
