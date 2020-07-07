package dao;

import domain.ChatRecord;
import domain.User;

import java.util.List;

public interface UserDao {
    User findUserByUsername(String username);

    User findUserByUsernameAndPassword(String username,String password);

    List<ChatRecord> findAllRelation(String username1);


    boolean addUserByUsername(String username1,String username2);


    boolean deleteUserByUsername(String username1, String username2);

    int countFriendByUsername(String username1);
}
