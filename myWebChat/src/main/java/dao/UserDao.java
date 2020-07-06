package dao;

import domain.ChatRecord;
import domain.User;

import java.util.List;

public interface UserDao {
    User findUserByUsername(String username);

    User findUserByUsernameAndPassword(String username,String password);

    List<ChatRecord> findAllRelation(String username1);



    void addUser(User user);

    void delUser(User user);
}
