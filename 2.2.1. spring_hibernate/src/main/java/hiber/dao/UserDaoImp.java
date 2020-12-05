package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();


    }

    @Override
    public User getUserByCar(String model, int series) {
        Query query = sessionFactory.getCurrentSession().createQuery("select user FROM User user where user.car.model = :model and user.car.series = :series")
                .setString("model", model)
                .setInteger("series", series);

        System.out.println(query);
        return (User) query.getSingleResult();


    }
}
