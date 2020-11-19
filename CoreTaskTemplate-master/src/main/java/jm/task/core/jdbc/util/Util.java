package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String USER = "root";
    private static final String PASS = "NazirkaPro86";
    private static final String URL = "jdbc:mysql://localhost:3306/userdb?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private Connection connection;

    public Util() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}


