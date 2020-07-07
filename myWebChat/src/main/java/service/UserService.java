package service;

import domain.ChatRecord;
import domain.User;

import java.util.List;


public interface UserService {
    List<ChatRecord> findAllRelation(String username1);

    User findUserByUsername(String username);

    boolean addUserByUsername(String username1,String username2);

    boolean deleteUserByUsername(String username1,String username2);

    int countFriendNum(String username1);
}
