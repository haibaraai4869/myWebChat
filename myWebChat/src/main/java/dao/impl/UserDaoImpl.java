package dao.impl;

import dao.UserDao;
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
    public List<User> findByChatName(String chatName) {
        try {
            String like_charName="%"+chatName+"%";
            String sql="select * from user where chatName like ?";
            List<User> foundUsers = jt.query(sql, new BeanPropertyRowMapper<User>(User.class), like_charName);
            return foundUsers;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public String findPicPathByUsername(String username) {
        try {
            String sql="select imag from user_imag where username = ?";
            String foundPath = jt.queryForObject(sql, String.class, username);
            return foundPath;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public void addPicPathBbyUsername(String username) {
        try {
            String sql="insert into user_imag (username,imag) values(?,'picture/@MDR3503(]DU$RZJL}{ZD2H.png')";
            jt.update(sql,username);
        } catch (DataAccessException e) {
           throw new RuntimeException(e);
            //当username设置为主键时，不允许插入相同username数据
        }
    }

    @Override
    public void updateUserInfo(String username, String reChatName, String rePassword) {
        String sql="update User set  chatname = ? ,password = ? where username = ?";
        jt.update(sql,reChatName,rePassword,username);
    }

    @Override
    public void updatePicPathByUsername(String username, String rePicPath) {
        try {
            String sql="replace into user_imag (username,imag) values(?,?)";
            jt.update(sql,username,rePicPath);
        } catch (DataAccessException e) {
            System.out.println("修改异常");
        }
    }



    @Override
    public void register(String reqUsername, String reqPassword, String reChatname) {
        try {
            String sql ="insert into user (username,password,chatname) values (?,?,?)";
            jt.update(sql,reqUsername,reqPassword,reChatname);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
