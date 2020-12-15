package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    User getUserByName(String name);

    void add(User user);

    void updateUsers(User user);

    void remove(User user);


    List<User> listUsers();
}
