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

    @Override
    public boolean addUserByUsername(String username1,String username2) {
        try {
            String sql ="insert into chatRecord (username1,username2) values (?,?)";
            jt.update(sql,username1,username2);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteUserByUsername(String username1, String username2) {
        try {
        String sql="delete from chatrecord where username1=? and username2 = ?";
        jt.update(sql,username1,username2);
        return true;
    } catch (Exception e) {
        return false;
    }
 }

    @Override
    public int countFriendByUsername(String username1) {
        try {
            String sql="select count(*) from chatrecord where username1 = ?";
            Integer friendNum = jt.queryForObject(sql,Integer.class, username1);
            return friendNum;
        } catch (DataAccessException e) {
            return 0;
        }
    }




}
