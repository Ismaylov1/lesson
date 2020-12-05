package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.UserDAO;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDAO userDao;

    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void add(User user) {
        this.userDao.add(user);
    }

    @Override
    @Transactional
    public void updateUsers(User user) {
        this.userDao.updateUsers(user);
    }

    @Override
    @Transactional
    public void remove(long id) {
        this.userDao.remove(id);
    }

    @Override
    @Transactional
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return this.userDao.listUsers();
    }
}
