package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import service.LoginService;

public class LoginServiceImpl implements LoginService {
    UserDao userdao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        User foundUser = userdao.findUserByUsernameAndPassword(username, password);
        return foundUser;
    }

    @Override
    public boolean register(String reqUsername, String reqPassword, String reChatname) {
        User userByUsername = userdao.findUserByUsername(reqUsername);
        System.out.println(userByUsername);
        if (userByUsername == null) {
            userdao.register(reqUsername, reqPassword, reChatname);
            return true;
        }
        return false;
    }
}