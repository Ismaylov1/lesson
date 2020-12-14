package dao;


import model.Role;
import model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {
    private final Map<String, User> userMap = Collections.singletonMap("test",
            new User(1L, "test", "test", "test", Collections.singleton(new Role(1L, "ROLE_USER")))); // name - уникальное значение, выступает в качестве ключа Map
    EntityManager entityManager;

    @Override
    public User getUserByName(String name) {
        return entityManager
                .createQuery("select user from User user where user.name =?1", User.class)
                .setParameter(1, name)
                .getSingleResult();

    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUsers(User user) {
        entityManager.merge(user);
    }

    @Override
    public void remove(User user) {
        entityManager.remove(user);
    }

    @Override
    public List<User> listUsers() {
        return null;
    }
}

