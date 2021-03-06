package service;

import domain.UserRelation;
import domain.User;

import java.util.List;


public interface UserService {
    List<UserRelation> findAllRelation(String username1);

    User findUserByUsername(String username);

    boolean addUserByUsername(String username1,String username2);

    boolean deleteUserByUsername(String username1,String username2);

    int countFriendNum(String username1);

    List<User> findByChatName(String chatName);

    String findPicPathByUsername(String username);

    void addPicPathByUsername(String username);

    void updateUserInfo(String username, String reChatName, String rePassword);

    void updatePicPathByUsername(String username, String rePicPath);

    void addExchangeFriend(String username1, String username2);


}
