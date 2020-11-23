package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {

    private static final String USER = "root";
    private static final String PASS = "NazirkaPro86";
    private static final String URL = "jdbc:mysql://localhost:3306/userdb?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private Connection connection;
    private SessionFactory sessionFactory;

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

    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties setting = new Properties();
                setting.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                setting.put(Environment.URL, "jdbc:mysql://localhost:3306/userdb?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
                        "&useLegacyDatetimeCode=false&serverTimezone=UTC");
                setting.put(Environment.USER, "root");
                setting.put(Environment.PASS, "NazirkaPro86");
                setting.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                setting.put(Environment.SHOW_SQL, "true");
                setting.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                setting.put(Environment.HBM2DDL_AUTO, "none");
                setting.put(Environment.POOL_SIZE, 10);

                configuration.setProperties(setting);
                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}





