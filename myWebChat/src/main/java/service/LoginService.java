package service;

import domain.User;

public interface LoginService {
    User login(String username, String password);
}
