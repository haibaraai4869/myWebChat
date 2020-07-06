package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.ChatRecord;
import domain.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public List<ChatRecord> findAllRelation(String username1) {
        UserDao userDao = new UserDaoImpl();
        List<ChatRecord> allRelation = userDao.findAllRelation(username1);
        return allRelation;
    }
}
