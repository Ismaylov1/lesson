package jm.task.core.jdbc.service;


import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoJDBCImpl usr = new UserDaoJDBCImpl();
    UserDaoHibernateImpl hibernate = new UserDaoHibernateImpl();

    public void createUsersTable() {
        hibernate.createUsersTable();

    }

    public void dropUsersTable() {
        hibernate.dropUsersTable();

    }

    public void saveUser(String name, String lastName, byte age) {
        hibernate.saveUser(name, lastName, age);

    }

    public void removeUserById(long id) {
        hibernate.removeUserById(id);

    }

    public List<User> getAllUsers() {
        return hibernate.getAllUsers();


    }

    public void cleanUsersTable() {
        hibernate.cleanUsersTable();

    }
}
