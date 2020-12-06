package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.UserDAO;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {


    private UserDAO userDao;
    @Autowired
    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void add(User user) {
        this.userDao.add(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
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

    @Override
    @Transactional(readOnly = true)
    public List<User> listUsers() {
        return this.userDao.listUsers();
    }
}
