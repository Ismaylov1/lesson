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
            Query query = session.createSQLQuery("create table if not exists users(" +
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
            Query query = session.createSQLQuery("DROP TABLE  users;");
            query.executeUpdate();
            t.commit();
            session.close();
        } catch (Exception e) {

        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = util.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String save = String.format("insert into users(name, lastname, age) values( '%s', '%s',%d);", name, lastName, age);
        try {
            Query query = session.createSQLQuery(save);
            query.executeUpdate();
            System.out.format(" User с именем – %s добавлен в базу данных \n", name);
            t.commit();
            session.close();

        } catch (Exception e) {

        }
    }

    @Override
    public void removeUserById(long id) {
        Session session = util.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String remove = String.format("delete from users where id = %d;", id);
        try {
            Query query = session.createSQLQuery(remove);
            query.executeUpdate();
            t.commit();
            session.close();
        } catch (Exception e) {

        }

    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String users = "select * from users";
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
            Query query = session.createSQLQuery("TRUNCATE TABLE  users;");
            query.executeUpdate();
            t.commit();
            session.close();
        } catch (Exception e) {

        }
    }
}
