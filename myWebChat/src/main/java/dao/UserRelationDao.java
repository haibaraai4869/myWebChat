package dao;

import domain.UserRelation;

import java.util.List;

public interface UserRelationDao {
    List<UserRelation> findAllRelation(String username1);

    int countFriendByUsername(String username1);

    boolean addUserByUsername(String username1,String username2);

    boolean deleteUserByUsername(String username1, String username2);

    void addExchangeFriend1(String username1, String username2);

    void addExchangeFriend2(String username2, String username1);


}
