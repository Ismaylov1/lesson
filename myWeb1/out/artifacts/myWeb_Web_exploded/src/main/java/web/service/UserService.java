package web.service;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.List;

public interface UserService {

    void add(User user);

    void updateUsers(User user);

    void remove(long id);

    public User getUserById(long id);


    List<User> listUsers();

}