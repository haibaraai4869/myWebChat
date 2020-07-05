package dao;

import domain.User;

import java.util.List;

public interface UserDao {
    User findUserByUsername(String username);

    User findUserByUsernameAndPassword(String username,String password);

    List<User> findAllFriendUser(String username);

    void addUser(User user);

    void delUser(User user);
}
