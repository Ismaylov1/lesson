package jm.task.core.jdbc;


import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Alex1", "sd", (byte) 18);
        userService.saveUser("Alex2", "sd", (byte) 18);
        userService.saveUser("Alex3", "sd", (byte) 18);
        userService.getAllUsers();
        userService.removeUserById(2);
        userService.cleanUsersTable();
        userService.dropUsersTable();



    }
}
