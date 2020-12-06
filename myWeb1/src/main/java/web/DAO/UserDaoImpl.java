package web.DAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void add(User user) {
        entityManager.persist(user);
        logger.info("User is saved. Users detail: " + user);
    }

    @Override
    public void updateUsers(User user) {
        entityManager.merge(user);

    }

    @Override
    public void remove(long id) {
        User user = new User();
        entityManager.remove(getUserById(id));
        logger.info("User is removed. User" + user);
    }


    @Override
    @SuppressWarnings("unchecked")
    public User getUserById(long id) {
        return entityManager
                .createQuery("select user from User user where user.id =?1", User.class)
                .setParameter(1, id)
                .getSingleResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        Query query = entityManager.createQuery("from User");
        return query.getResultList();
    }
}
