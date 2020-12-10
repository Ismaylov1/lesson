package dao;


import model.Role;
import model.User;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {
    private final Map<String, User> userMap = Collections.singletonMap("test",
            new User(1L, "test", "test", Collections.singleton(new Role(1L, "ROLE_USER")))); // name - уникальное значение, выступает в качестве ключа Map

    @Override
    public User getUserByName(String name) {
        if (!userMap.containsKey(name)) {
            return null;
        }

        return userMap.get(name);
    }

    @Override
    public void add(User user) {

    }

    @Override
    public void updateUsers(User user) {

    }

    @Override
    public void remove(User user) {

    }

    @Override
    public List<User> listUsers() {
        return null;
    }
}

