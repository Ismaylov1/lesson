package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.UserDaoHibernateImpl;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        //Hibernate
        UserDaoHibernateImpl hiber = new UserDaoHibernateImpl();
        hiber.createUsersTable();
        hiber.saveUser("sd", "sd", (byte) 15);
        hiber.saveUser("sd", "sd", (byte) 15);
        hiber.saveUser("sd", "sd", (byte) 15);
        hiber.saveUser("sd", "sd", (byte) 15);
        hiber.getAllUsers();

        hiber.removeUserById(1);
        hiber.cleanUsersTable();
        hiber.dropUsersTable();
    }
}
