package web;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import web.DAO.UserDaoImpl;
import web.config.RootConfig;
import web.model.User;

public class MainApp {

    public static void main(String[] args) {


        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(RootConfig.class);
        UserDaoImpl userDao = context.getBean(UserDaoImpl.class);
        User user1 = new User("Senya", "Ismailov");
        userDao.add(user1);
    }
}
