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

    @Override
    public User findUserByUsername(String username) {
        UserDao userDao = new UserDaoImpl();
        User foundUser = userDao.findUserByUsername(username);
        return foundUser;
    }

    @Override
    public boolean addUserByUsername(String username1,String username2) {
        UserDao userDao = new UserDaoImpl();
        boolean addSuccess = userDao.addUserByUsername(username1, username2);
        return addSuccess;
    }

    @Override
    public boolean deleteUserByUsername(String username1, String username2) {
        UserDao userDao = new UserDaoImpl();
        boolean delSuccess = userDao.deleteUserByUsername(username1, username2);
        return delSuccess;
    }

    @Override
    public int countFriendNum(String username1) {
        UserDao userDao = new UserDaoImpl();
        int friendNum = userDao.countFriendByUsername(username1);
        return friendNum;
    }
}
