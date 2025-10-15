package main.service;

import main.dao.UserDao;
import main.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private final UserDao userDao;

@Autowired
public UserService(UserDao userDao) {
    this.userDao = userDao;
}

    public void saveUser(User user) {

        userDao.save(user);

    }

}