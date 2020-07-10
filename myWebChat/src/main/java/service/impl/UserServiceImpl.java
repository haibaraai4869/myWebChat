package service.impl;

import dao.UserDao;
import dao.UserRelationDao;
import dao.impl.UserDaoImpl;
import dao.impl.UserRelationDaoImpl;
import domain.UserRelation;
import domain.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserRelationDao userRelationdao = new UserRelationDaoImpl();
    UserDao userDao = new UserDaoImpl();
    @Override
    public List<UserRelation> findAllRelation(String username1) {
        List<UserRelation> allRelation = userRelationdao.findAllRelation(username1);
        return allRelation;
    }

    @Override
    public User findUserByUsername(String username) {
        User foundUser = userDao.findUserByUsername(username);
        return foundUser;
    }

    @Override
    public boolean addUserByUsername(String username1,String username2) {
        boolean addSuccess = userRelationdao.addUserByUsername(username1, username2);
        return addSuccess;
    }

    @Override
    public boolean deleteUserByUsername(String username1, String username2) {
        boolean delSuccess = userRelationdao.deleteUserByUsername(username1, username2);
        return delSuccess;
    }

    @Override
    public int countFriendNum(String username1) {
        int friendNum = userRelationdao.countFriendByUsername(username1);
        return friendNum;
    }

    @Override
    public List<User> findByChatName(String chatName) {
        List<User> foundUsers = userDao.findByChatName(chatName);
        return foundUsers;
    }

    @Override
    public String findPicPathByUsername(String username) {
        String foundPicPath = userDao.findPicPathByUsername(username);
        return foundPicPath;
    }

    @Override
    public void addPicPathByUsername(String username) {
        userDao.addPicPathBbyUsername(username);
    }

    @Override
    public void updatePicPathByUsername(String username, String rePicPath) {
        userDao.updatePicPathByUsername(username,rePicPath);
    }

    @Override
    public void updateUserInfo(String username, String reChatName, String rePassword) {
        userDao.findUserByUsername(username);
        userDao.updateUserInfo(username,reChatName,rePassword);
    }

    @Override
    public void addExchangeFriend(String username1, String username2) {
        userRelationdao.addExchangeFriend1(username1,username2);
        userRelationdao.addExchangeFriend2(username2,username1);
    }
}
