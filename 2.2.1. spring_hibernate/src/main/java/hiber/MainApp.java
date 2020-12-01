package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("Senya", "Ismailov", "asdasd@mail.com");
        user1.setCar(new Car("Mercedes", 1));
        userService.add(user1);

        User user2 = new User("Magamed", "Maga", "google.com");
        user2.setCar(new Car("Bmw", 2));
        userService.add(user2);

        User userCar = userService.getUserHaveCar("Bmw", 2);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar().getModel());
            //
            System.out.println("Пользователь с автомабилем БМВ "+userCar);

        }

        context.close();
    }
}
