package web.dao;


import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
//    private final Map<String, User> userMap = Collections.singletonMap("test",
//            new User(1L, "test", "test","test", Collections.singleton(new Role(1L, "ROLE_USER")))); // name - уникальное значение, выступает в качестве ключа Map

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUserByName(String name) {
        String nameSQL = String.format("SELECT * FROM userdb.users where name='%s'", name);
        return (User) entityManager.createQuery(nameSQL);
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
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        Query query = entityManager.createQuery("from users");
        return query.getResultList();
    }
}

