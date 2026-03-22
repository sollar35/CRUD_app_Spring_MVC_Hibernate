package web.service;


import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;


import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{


    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAll() {
        return userDao.findAll();
    }

    public void save(User user) {
        userDao.save(user);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public void delete(Long id) {
        userDao.delete(id);
    }

    public User getById(Long id) {
        return userDao.findById(id);
    }
}
