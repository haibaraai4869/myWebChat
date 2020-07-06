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
}
