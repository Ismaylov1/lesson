package web.service;


import web.model.User;

import java.util.List;

public interface UserService {

    void add(User user);

    void updateUser(User user);

    void remove(long id);

     User getUserById(long id);


    List<User> listUsers();

}