package dao;

import domain.ChatRecord;
import domain.CorrespondRecord;
import domain.User;
import domain.UsernamePicPathMap;

import java.util.List;

public interface UserDao {
    User findUserByUsername(String username);

    User findUserByUsernameAndPassword(String username,String password);

    List<ChatRecord> findAllRelation(String username1);


    boolean addUserByUsername(String username1,String username2);


    boolean deleteUserByUsername(String username1, String username2);

    int countFriendByUsername(String username1);

    List<User> findByChatName(String chatName);

    String findPicPathByUsername(String username);

    void addPicPathBbyUsername(String username);

    void updateUserInfo(String username, String reChatName, String rePassword);

    void updatePicPathByUsername(String username, String rePicPath);


    void addExchangeFriend1(String username1, String username2);

    void addExchangeFriend2(String username2, String username1);
}
