package web;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import web.config.RootConfig;
import web.model.User;
import web.service.UserService;

public class MainApp {

    public static void main(String[] args) {


        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(RootConfig.class);
        UserService userService = context.getBean(UserService.class);
        User user = new User("Senya", "Ismailov");
        userService.add(user);
    }
}
