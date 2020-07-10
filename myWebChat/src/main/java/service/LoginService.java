package service;

import domain.User;

public interface LoginService {
    User login(String username, String password);

    boolean register(String reqUsername, String reqPassword, String reChatname);
}
