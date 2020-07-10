package dao;

import domain.User;

import java.util.List;

public interface UserDao {
    User findUserByUsername(String username);

    User findUserByUsernameAndPassword(String username,String password);

    String findPicPathByUsername(String username);

    void addPicPathBbyUsername(String username);

    void updateUserInfo(String username, String reChatName, String rePassword);

    void updatePicPathByUsername(String username, String rePicPath);

    List<User> findByChatName(String chatName);

    void register(String reqUsername, String reqPassword, String reChatname);
}
