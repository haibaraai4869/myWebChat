package dao.impl;

import dao.UserDao;
import domain.ChatRecord;
import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class UserDaoImpl implements UserDao {
    JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public User findUserByUsername(String username) {
        try {
            String sql="select * from User where username = ?";
            User foundUser = jt.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
        return foundUser;
        } catch (DataAccessException e) {
            return null;//如果没有查到捕捉异常返回空
        }
    }

    public User findUserByUsernameAndPassword(String username,String password) {
        try {
            String sql="select * from User where username = ? and password = ?";
            User foundUser = jt.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username,password);
            return foundUser;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public List<ChatRecord> findAllRelation(String username1) {
        try {
            String sql="select * from chatrecord where username1 = ?";
            List<ChatRecord> relationList = jt.query(sql, new BeanPropertyRowMapper<ChatRecord>(ChatRecord.class), username1);
            return relationList;
        } catch (DataAccessException e) {
            return null;
        }
    }


/*    @Override
    public List<User> findAllFriend(List<String> username2s) {

        try {
            List<User> allFriend = null;
            String sql = "select * from user where username = ?";
            for (String username2 : username2s) {
                User user = (User) jt.query(sql, new BeanPropertyRowMapper<User>(User.class), username2);
                allFriend.add(user);
            }
            return allFriend;
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }*/

    @Override
    public void addUser(User user) {

    }

    @Override
    public void delUser(User user) {

    }
}
